package com.example.demoapiarch.source.callbacks

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.path.PathBodyResponse
import com.example.demoapiarch.model.path.Step
import com.example.demoapiarch.model.place.PlaceBodyResponse
import com.example.demoapiarch.source.MapsCallback

interface PathCallback: MapsCallback {
    fun onSuccessFromLocal(referenceId: String,
                           destinationId: String,
                           distance: Int,
                           referencePlace: Node?,
                           steps: List<Step>?)
    fun onSuccessFromRemote(apiResponse: GenericApiResponse<PathBodyResponse>,
                            lastUpdate: Long)
}