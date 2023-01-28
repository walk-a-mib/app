package com.example.walk_a_mib.source

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.source.PlaceCallback

abstract class BasePlaceLocalDataSource {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(id: String)
    abstract fun insertPlace(place: Node)

}