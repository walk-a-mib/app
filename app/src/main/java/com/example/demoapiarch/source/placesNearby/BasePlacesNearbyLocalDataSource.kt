package com.example.demoapiarch.source.placesNearby

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.placesNearby.Neighbour
import com.example.demoapiarch.source.callbacks.PlacesNearbyCallback

abstract class BasePlacesNearbyLocalDataSource {
    var placeNearbyCallback: PlacesNearbyCallback? = null

    abstract fun getPlacesNearby(referenceId: String, maxDistance: Int)
    abstract fun insertPlacesNearby(referencePlace: Node, maxDistance: Int, neighbours: List<Neighbour>)
}