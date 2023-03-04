import json
from gremlin_python.driver import client, serializer, protocol
from gremlin_python.driver.protocol import GremlinServerError
import sys
import traceback
from dotenv import load_dotenv
import os
from threading import Timer
import haversine as hs

load_dotenv()

def parse_map_json():
    """"Parsing json file to Python object"""

    map_json = open('u24.json') # setup_graph_db/u24.json
    graph = json.load(map_json)

    print("[INFO]: JSON parsed!")

    return graph

# Getting configuration info from .env file
endpoint = os.getenv('AZURE_ENDPOINT')
database = os.getenv('AZURE_DATABASE')
graph = os.getenv('AZURE_GRAPH')
key = os.getenv('AZURE_KEY')

# vertexs
vertex_list = []

def create_vertices(graph):
    """ Create vertices """
    # print(graph["buildings"])
    print(f"[INFO]: Creating vertices..")

    for building in graph["buildings"]:
        for vertex in building["vertices"]:
            saved_vertex = {}
            
            # creating vertex
            query = "g.addV('POI')"

            for key in vertex.keys():
                # adding properties to the vertex
                query += f".property('{key}', '{vertex[key]}')"
                
                # storing vertex inside dict
                saved_vertex[key] = vertex[key]

            # adding partitionKey property (required by Azure)
            query += ".property('maps', 'partitionKey');"
            
            # saving dict inside array
            vertex_list.append(saved_vertex)

            callback = client_.submitAsync(query)
            res = callback.result().all().result()

        if len(res) == 0:
            return None

        print(f"[SUCCESS]: Vertices created correctly")

    return res[0]

def create_edges():
    """"Create edge between vertices"""
    print(f"[INFO]: Creating edges..")

    for building in graph["buildings"]:
        for edge in building["edges"]:
            # getting vertices reference
            from_vertex = f"g.V().has('id','{edge['from_id']}')"
            to_vertex = f"g.V().has('id','{edge['to_id']}')"          

            # adding edge
            new_edge = f"{from_vertex}.addE('can_reach').to({to_vertex})"
            
            # adding distance
            from_vertex_geo = (vertex_list[int(edge['from_id'])-1]['lat'], vertex_list[int(edge['from_id'])-1]['lon'])
            to_vertex_geo = (vertex_list[int(edge['to_id'])-1]['lat'], vertex_list[int(edge['to_id'])-1]['lon'])
            
            distance = hs.haversine(from_vertex_geo, to_vertex_geo, unit='m')
            
            new_edge += f".property('distance', '{distance}')"
            
            print(f"    - [GEO]: Distance between {edge['from_id']} and {edge['to_id']}: {distance}")

            # adding properties to edge
            for property in edge['properties']:
                new_edge += f".property('{property}', '{edge['properties'][property]}')"

            callback = client_.submitAsync(new_edge)
            res = callback.result().all().result()

            print(f"[INFO]: Added edge: {edge['from_id']} -> {edge['to_id']}")

        if len(res) == 0:
            return None

        print(f"[SUCCESS]: Edges created correctly")

    return res[0]

try:
    global client_
    client_ = client.Client('wss://' + endpoint + '.gremlin.cosmos.azure.com:443/', 'g',
                           username="/dbs/" + database + "/colls/" + graph,
                           password=key,
                           message_serializer=serializer.GraphSONSerializersV2d0()
                           )

    print("Welcome to Walk@miB graph API!")

    graph = parse_map_json()
    
    create_vertices(graph)
    
    print("Waiting..")
    Timer(5.0, create_edges())

    print('\n--------------------------------------------------------\n')



except GremlinServerError as e:
    print('Code: {0}, Attributes: {1}'.format(e.status_code, e.status_attributes))
    traceback.print_exc(file=sys.stdout) 
    sys.exit(1)

print("\nCompleted.")