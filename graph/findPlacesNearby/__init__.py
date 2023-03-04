import logging

import azure.functions as func

from graph_api import findPlacesNearby, get_place

import json

from data_pruning import prune_node

def main(req: func.HttpRequest) -> func.HttpResponse:

    if req.method != "GET":
        return func.HttpResponse(
             status_code=405
        )

    max_distance = req.params.get('max_distance')
    reference_place_id = req.params.get('reference_place_id')

    success = {"status": "ok"}
    failure = {"status": "error"}

    if not max_distance:
        max_distance = 30

    if reference_place_id: 
        reference_place = get_place(reference_place_id)
        if (reference_place):
            try:   
                res = findPlacesNearby(reference_place_id, max_distance) #prune_nodes(findPlacesNearby(reference_place_id, max_distance))
                for i in range(len(res)):
                    res[i]['place'] = prune_node(res[i]['place'])

                if res:
                    success.update({'responseBody': {'referencePlace' : prune_node(reference_place), 'placesNearby': res}})
                    return func.HttpResponse(      
                        str(success),
                        status_code=200
                    )
                else:
                    return func.HttpResponse(
                        status_code=204
                    )
                    
            except ValueError as e:
                failure.update({"message": "Wrong parameter: max_distance must be an integer"})
                return func.HttpResponse(
                    str(failure),
                    status_code=400
                )   
        else:
            failure.update({"message": "Wrong parameter: reference_place_id is not valid."})
            return func.HttpResponse(
             str(failure),
             status_code=400
        )        
    else:
        failure.update({"message": "Missing parameters. Required: reference_place_id."})
        return func.HttpResponse(
             str(failure),
             status_code=400
        )
