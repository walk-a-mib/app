package com.example.walk_a_mib.model

import com.example.walk_a_mib.logic_layer.domain.Path
import com.example.walk_a_mib.model.place.AllPlacesBodyResponse
import com.example.walk_a_mib.model.place.PlaceBodyResponse
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse

open class CallResult {
    fun isSuccess(): Boolean {
        return this is SuccessPlace
                || this is SuccessPlacesNearby
                || this is SuccessPath
                || this is SuccessAllPlaces
    }

    class SuccessPlace(val placeResponse: PlaceBodyResponse) : CallResult()

    class SuccessPlacesNearby(val placesNearbyResponse: PlacesNearbyBodyResponse) : CallResult()

    class SuccessPath(val pathResponse: Path) : CallResult()

    class SuccessAllPlaces(val allPlaces: AllPlacesBodyResponse) : CallResult()

    class Error(val message: String?) : CallResult()

    override fun toString(): String {
        //if (isSuccess())
        //    return (this as SuccessPlace).placeResponse.place.toString()
        return "TODO CALL RESULT TOSTRING"
    }
}