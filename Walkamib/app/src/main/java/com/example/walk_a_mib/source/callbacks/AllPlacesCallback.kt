package com.example.walk_a_mib.source.callbacks

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.place.AllPlacesBodyResponse
import com.example.walk_a_mib.source.MapsCallback

interface AllPlacesCallback: MapsCallback {
    fun onSuccessFromLocal(places: List<Node>?)

    fun onSuccessFromRemoteAllPlaces(apiResponse: GenericApiResponse<AllPlacesBodyResponse>,
                                     lastUpdate: Long)
}