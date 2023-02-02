package com.example.walk_a_mib.source.place

import com.example.walk_a_mib.source.callbacks.PlaceCallback

abstract class BasePlaceRemoteDataSource() {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(placeId : String)
}