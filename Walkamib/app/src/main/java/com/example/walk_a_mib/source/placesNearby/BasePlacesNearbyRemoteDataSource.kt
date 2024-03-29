package com.example.walk_a_mib.source.placesNearby

import com.example.walk_a_mib.source.callback.PlacesNearbyCallback

abstract class BasePlacesNearbyRemoteDataSource() {
    var placeNearbyCallback: PlacesNearbyCallback? = null

    abstract fun getPlacesNearby(referenceId: String, maxDistance: Int)
}