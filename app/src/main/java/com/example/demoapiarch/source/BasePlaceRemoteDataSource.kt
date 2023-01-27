package com.example.demoapiarch.source

abstract class BasePlaceRemoteDataSource {
    var placeCallback : PlaceCallback? = null

    abstract fun getPlace(placeId : String)
}