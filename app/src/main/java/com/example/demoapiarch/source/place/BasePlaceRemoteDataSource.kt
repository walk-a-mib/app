package com.example.demoapiarch.source.place

import com.example.demoapiarch.source.callbacks.PlaceCallback

abstract class BasePlaceRemoteDataSource() {
    var placeCallback: PlaceCallback? = null

    abstract fun getPlace(placeId : String)
}