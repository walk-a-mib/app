package com.example.demoapiarch.source.place

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.source.MapsCallback
import com.example.demoapiarch.source.callbacks.PlaceCallback

abstract class BasePlaceLocalDataSource() {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(id: String)
    abstract fun insertPlace(place: Node)
}