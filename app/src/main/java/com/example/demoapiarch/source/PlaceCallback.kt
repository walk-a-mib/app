package com.example.demoapiarch.source

import com.example.demoapiarch.place.PlaceApiResponse
import com.example.demoapiarch.domain.Node

interface PlaceCallback {
    fun onSuccessFromRemote(placeApiResponse: PlaceApiResponse, lastUpdate: Long)
    fun onFailureFromRemote(exception: Exception)
    fun onSuccessFromLocal(place: Node)
    fun onFailureFromLocal(exception: Exception)
}