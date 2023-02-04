package com.example.walk_a_mib.source.place

import com.example.walk_a_mib.source.callbacks.AllPlacesCallback
import com.example.walk_a_mib.source.callbacks.PlaceCallback

abstract class BasePlaceRemoteDataSource() {
    var placeCallback: PlaceCallback? = null
    var allPlacesCallback: AllPlacesCallback? = null

    abstract fun getPlace(placeId : String)
    abstract fun getAllPlaces()
}