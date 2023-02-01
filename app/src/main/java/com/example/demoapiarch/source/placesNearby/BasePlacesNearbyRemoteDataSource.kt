package com.example.demoapiarch.source.placesNearby

import com.example.demoapiarch.source.callbacks.PlacesNearbyCallback

abstract class BasePlacesNearbyRemoteDataSource() {
    var placeNearbyCallback: PlacesNearbyCallback? = null

    abstract fun getPlacesNearby(referenceId: String, maxDistance: Int)
}