package com.example.walk_a_mib.source.place

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.source.callbacks.AllPlacesCallback
import com.example.walk_a_mib.source.callbacks.PlaceCallback

abstract class BasePlaceLocalDataSource() {
    var placeCallback: PlaceCallback? = null
    var allPlacesCallback: AllPlacesCallback? = null

    abstract fun getPlace(id: String)
    abstract fun getAllPlaces()
    abstract fun insertPlace(place: Node)
    abstract fun insertPlaces(places: List<Node>)
}