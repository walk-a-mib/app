package com.example.walk_a_mib.model

import com.example.walk_a_mib.model.place.PlaceBodyResponse
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import com.example.walk_a_mib.repository.placesNearby.PlacesNearbyRepository

open class CallResult {
    fun isSuccess(): Boolean {
        return this is SuccessPlace || this is SuccessPlacesNearby
    }

    class SuccessPlace(val placeResponse: PlaceBodyResponse) : CallResult()

    class SuccessPlacesNearby(val placesNearbyResponse: PlacesNearbyBodyResponse) : CallResult()

    class Error(val message: String?) : CallResult()

    override fun toString(): String {
        //if (isSuccess())
        //    return (this as SuccessPlace).placeResponse.place.toString()
        return "TODO CALL RESULT TOSTRING"
    }
}