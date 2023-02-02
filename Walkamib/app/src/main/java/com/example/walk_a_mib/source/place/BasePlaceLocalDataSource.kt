package com.example.walk_a_mib.source.place

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.source.MapsCallback
import com.example.walk_a_mib.source.callbacks.PlaceCallback

abstract class BasePlaceLocalDataSource() {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(id: String)
    abstract fun insertPlace(place: Node)
}