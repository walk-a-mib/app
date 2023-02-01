package com.example.demoapiarch.source.callbacks

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.place.PlaceBodyResponse
import com.example.demoapiarch.source.MapsCallback

interface PlaceCallback: MapsCallback {
    fun onSuccessFromLocal(reqId: String, place: Node?)
    fun onSuccessFromRemote(apiResponse: GenericApiResponse<PlaceBodyResponse>, lastUpdate: Long)
}