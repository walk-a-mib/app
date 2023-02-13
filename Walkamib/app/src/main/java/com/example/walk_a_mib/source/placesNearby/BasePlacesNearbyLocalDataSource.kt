package com.example.walk_a_mib.source.placesNearby

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.placesNearby.Neighbour
import com.example.walk_a_mib.source.callbacks.PlacesNearbyCallback

abstract class BasePlacesNearbyLocalDataSource {
    var placeNearbyCallback: PlacesNearbyCallback? = null

    abstract fun getPlacesNearby(referenceId: String, maxDistance: Int)
    abstract fun insertPlacesNearby(referencePlace: Node, maxDistance: Int, neighbours: List<Neighbour>)
}