package com.example.walk_a_mib.source

import com.example.walk_a_mib.source.PlaceCallback

abstract class BasePlaceRemoteDataSource {
    var placeCallback : PlaceCallback? = null

    abstract fun getPlace(placeId : String)
}