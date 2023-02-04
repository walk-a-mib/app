package com.example.demoapiarch.source.place

import com.example.demoapiarch.source.callbacks.AllPlacesCallback
import com.example.demoapiarch.source.callbacks.PlaceCallback

abstract class BasePlaceRemoteDataSource() {
    var placeCallback: PlaceCallback? = null
    var allPlacesCallback: AllPlacesCallback? = null

    abstract fun getPlace(placeId : String)
    abstract fun getAllPlaces()
}