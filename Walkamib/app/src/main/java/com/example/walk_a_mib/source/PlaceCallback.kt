package com.example.walk_a_mib.source

import com.example.walk_a_mib.model.PlaceApiResponse
import com.example.walk_a_mib.logic_layer.domain.Node

interface PlaceCallback {
    fun onSuccessFromRemote(placeApiResponse: PlaceApiResponse, lastUpdate: Long)
    fun onFailureFromRemote(exception: Exception)
    fun onSuccessFromLocal(reqId: String, place: Node?)
    fun onFailureFromLocal(exception: Exception)
}