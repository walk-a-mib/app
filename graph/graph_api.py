from gremlin_python.driver import client, serializer, protocol
from gremlin_python.driver.protocol import GremlinServerError
from pathfinding_utils import *

import sys
import traceback

endpoint = "walkatmib"
database = "maps"
graph = "map"
key = "hFH9y8I9kCN8jYvz0kLCHcQUW4kERdrGsvmc56PBQjFHoVRwOyMdUcqz3OvxMrKB6xB6qhi6vw2cACDbfSUaYA=="

def findPlacesNearby(reference_place, max_distance):
    max_distance = int(max_distance)

    nodes = client_.submitAsync("g.V()").result().all().result()
    edges = client_.submitAsync("g.V().outE()").result().all().result()

    edges_lengths = dict()
    nodes_info = dict()
    neighbours = dict()

    for node in nodes:
        nodes_info[node['id']] = node


    for edge in edges:
        edges_lengths[(edge['outV'], edge['inV'])] = int(edge['properties']['distance'])
        neighbours.setdefault(edge['outV'], list())
        neighbours[edge['outV']].append(edge['inV'])

    return bfs_nearest_nodes(nodes_info, edges_lengths, neighbours, reference_place, max_distance)

def get_place(placeID):
    callback = client_.submitAsync(f"g.V('{placeID}')")
    res = callback.result().all().result()

    if res:
        return res[0]
    else:
        return []

def findNearestPlace(reference_place, label):

    callback = client_.submitAsync(
            f"""g.V('{reference_place}').repeat(outE().
                inV().simplePath()).
                until(hasLabel('{label}')).as('place').
                path().map(unfold().
                    coalesce(
                        values('distance'),
                        constant(0.0)
                    ).sum()).
                    as('distance').
                    select('distance', 'place').""")

    res = callback.result().all().result()
    
    if len(res) == 0:
        return []
    
    return res[0]

def findPath(reference_place_id, destination_place_id, optional_params):

    #filters = {
    #    "availabilty": True,
    #    "accessibility": True,
    #    "indoor":  True
    #}
    
    filters_code = ""
    for key in optional_params:
        if optional_params[key] == 'true' or optional_params[key] == 'false':
            value = optional_params[key]
        else:
            value = f"'{optional_params[key]}'"
        filters_code += f".has('{key}', {value})"

    callback = client_.submitAsync(
            f"""g.V('{reference_place_id}').repeat(outE(){filters_code}.inV().simplePath()).
                    until(hasId('{destination_place_id}')).path().as('path').
                    map(unfold().
                        coalesce(
                        values('distance'),
                        constant(0.0)
                    ).sum()).
                    as('distance').
                    select('distance', 'path').""")

    res = callback.result().all().result()

    if len(res) == 0:
        return None
    
    return res[0]

    
try:
    global client_
    client_ = client.Client('wss://' + endpoint + '.gremlin.cosmos.azure.com:443/', 'g',
                           username="/dbs/" + database + "/colls/" + graph,
                           password=key,
                           message_serializer=serializer.GraphSONSerializersV2d0()
                           )   

except GremlinServerError as e:
    print('Code: {0}, Attributes: {1}'.format(e.status_code, e.status_attributes))
    traceback.print_exc(file=sys.stdout) 
    sys.exit(1)