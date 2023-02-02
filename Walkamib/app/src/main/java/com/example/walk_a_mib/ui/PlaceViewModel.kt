package com.example.walk_a_mib.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.repository.place.IPlaceRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository


class PlaceViewModel(var placeRepository: IPlaceRepository, var placesNearbyRepository: IPlacesNearbyRepository) : ViewModel() {
    val TAG: String = PlaceViewModel::class.java.simpleName

    var place: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var placesNearby: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<CallResult> {
        place = placeRepository.fetchPlace(placeId, lastUpdate)!!
        return place
    }

    fun fetchPlacesNearby(referencePlaceId: String, maxDistance: Int, lastUpdate: Long): MutableLiveData<CallResult> {
        placesNearby = placesNearbyRepository.fetchPlacesNearby(referencePlaceId, maxDistance, lastUpdate)!!
        return placesNearby
    }
}