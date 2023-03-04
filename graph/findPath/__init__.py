import logging

import azure.functions as func

from graph_api import findPath

from data_pruning import prune_path

def main(req: func.HttpRequest) -> func.HttpResponse:
    
    if req.method != "POST":
        return func.HttpResponse(
             status_code=405
        )

    success = {"status": "ok"}
    failure = {"status": "error"}

    try:
        params = req.get_json()
    except:
        failure.update({"message": "Could not parse json body."})
        return func.HttpResponse(
            str(failure),
            status_code=400
        )
        
    try:
        reference_place_id = params['reference_place_id']
        destination_place_id = params['destination_place_id']
    except Exception as e:
        failure.update({"message": "Missing parameters. Required: reference_place_id, destination_place_id."})
        return func.HttpResponse(
            str(failure),
            status_code=400
        )

    optional_filters = dict()
 
    if 'optional_filters' in params.keys():
        optional_filters_list = list()
        try:
            optional_filters_list = params['optional_filters']
            if type(optional_filters_list) is not list:
                raise Exception
        except Exception:
            failure.update({"message": "Wrong parameter: optional_filters must be a list of objects."})
            return func.HttpResponse(
                str(failure),
                status_code=400
            )
        for filter in optional_filters_list:
            optional_filters.update(filter)      

    res = findPath(reference_place_id, destination_place_id, optional_filters)

    if res:
        pruned_path = prune_path(res['path']['objects'])

        pruned_res = {
            'distance': res['distance'],
            'path': pruned_path
        }
        success.update(pruned_res)
        return func.HttpResponse(
            str(success),
            status_code=200
        )
    else:
        return func.HttpResponse(
            status_code=204
        )
    
