package com.example.walk_a_mib.source.callbacks

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.placesNearby.Neighbour
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import com.example.walk_a_mib.source.MapsCallback

interface PlacesNearbyCallback: MapsCallback {
    fun onSuccessFromLocal(referenceId: String,
                           maxDistance: Int,
                           referencePlace: Node?,
                           neighbours: List<Neighbour>?)
    fun onSuccessFromRemote(apiResponse: GenericApiResponse<PlacesNearbyBodyResponse>,
                            maxDistance: Int,
                            lastUpdate: Long)
}