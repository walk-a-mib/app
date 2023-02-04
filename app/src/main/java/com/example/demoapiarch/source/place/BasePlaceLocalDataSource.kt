package com.example.demoapiarch.source.place

import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.source.MapsCallback
import com.example.demoapiarch.source.callbacks.AllPlacesCallback
import com.example.demoapiarch.source.callbacks.PlaceCallback

abstract class BasePlaceLocalDataSource() {
    var placeCallback: PlaceCallback? = null
    var allPlacesCallback: AllPlacesCallback? = null

    abstract fun getPlace(id: String)
    abstract fun getAllPlaces()
    abstract fun insertPlace(place: Node)
    abstract fun insertPlaces(places: List<Node>)
}