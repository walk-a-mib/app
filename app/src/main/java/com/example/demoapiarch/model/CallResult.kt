package com.example.demoapiarch.model

import com.example.demoapiarch.domain.Path
import com.example.demoapiarch.model.path.PathBodyResponse
import com.example.demoapiarch.model.place.AllPlacesBodyResponse
import com.example.demoapiarch.model.place.PlaceBodyResponse
import com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse
import com.example.demoapiarch.repository.placesNearby.PlacesNearbyRepository

open class CallResult {
    fun isSuccess(): Boolean {
        return this is SuccessPlace
                || this is SuccessPlacesNearby
                || this is SuccessPath
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