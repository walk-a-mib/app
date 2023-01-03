package com.example.demoapiarch.source

import com.example.demoapiarch.domain.Node

abstract class BasePlaceLocalDataSource {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(id: String)
    abstract fun insertPlace(place: Node)

}