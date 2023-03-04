import logging

import azure.functions as func

from graph_api import findNearestPlace, get_place

from data_pruning import prune_node


def main(req: func.HttpRequest) -> func.HttpResponse:

    if req.method != "GET":
        return func.HttpResponse(
             status_code=405
        )

    reference_place_id = req.params.get('reference_place_id')
    label = req.params.get('label')

    success = {"status": "ok"}
    failure = {"status": "error"}

    if reference_place_id and label:
        if (get_place(reference_place_id)):
            res = findNearestPlace(reference_place_id, label)

            if res:
                pruned_res = {
                    'distance': res['distance'],
                    'place': prune_node(res['place'])
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
        else:
            failure.update({"message": "Wrong parameter: reference_place_id is not valid."})
            return func.HttpResponse(
                str(failure),
                status_code=400     
            )
    else:
        failure.update({"message": "Missing parameters. Required: reference_place_id, label."})
        return func.HttpResponse(
            str(failure),
            status_code=400
        )
