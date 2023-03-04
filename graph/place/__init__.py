import logging

import azure.functions as func

from graph_api import *

import json

from data_pruning import prune_node

def main(req: func.HttpRequest) -> func.HttpResponse:

    if req.method != "GET":
        return func.HttpResponse(
             status_code=405
        )

    place = req.params.get('place_id')
    
    success = {"status": "ok"}
    failure = {"status": "error"}

    if not place:
        failure.update({"message": "Missing parameters. Required: place_id."})
        return func.HttpResponse(
             status_code=400
        )

    res = get_place(place)

    if res:
        success.update({'responseBody': {"place": prune_node(res)}})
        ##success.update({"place": prune_node(res)})
        return func.HttpResponse(   
            str(success),
            status_code=200
        )
    else:    
        return func.HttpResponse(
            str(success),
            status_code=204
        )


        