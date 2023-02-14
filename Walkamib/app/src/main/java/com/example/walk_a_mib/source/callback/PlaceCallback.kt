package com.example.walk_a_mib.source.callback

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.node.PlaceBodyResponse
import com.example.walk_a_mib.source.MapsCallback

interface PlaceCallback: MapsCallback {
    fun onSuccessFromLocalPlace(reqId: String, place: Node?)
    fun onSuccessFromRemotePlace(apiResponse: GenericApiResponse<PlaceBodyResponse>,
                                 lastUpdate: Long)
}