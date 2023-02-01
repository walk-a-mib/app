package com.example.demoapiarch.source.callbacks

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.placesNearby.Neighbour
import com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse
import com.example.demoapiarch.source.MapsCallback

interface PlacesNearbyCallback: MapsCallback {
    fun onSuccessFromLocal(referenceId: String,
                           maxDistance: Int,
                           referencePlace: Node?,
                           neighbours: List<Neighbour>?)
    fun onSuccessFromRemote(apiResponse: GenericApiResponse<PlacesNearbyBodyResponse>,
                            maxDistance: Int,
                            lastUpdate: Long)
}