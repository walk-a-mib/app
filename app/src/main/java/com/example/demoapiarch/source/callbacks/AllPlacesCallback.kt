package com.example.demoapiarch.source.callbacks

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.place.AllPlacesBodyResponse
import com.example.demoapiarch.model.place.PlaceBodyResponse
import com.example.demoapiarch.source.MapsCallback

interface AllPlacesCallback: MapsCallback {
    fun onSuccessFromLocal(places: List<Node>?)

    fun onSuccessFromRemoteAllPlaces(apiResponse: GenericApiResponse<AllPlacesBodyResponse>,
                                 lastUpdate: Long)
}