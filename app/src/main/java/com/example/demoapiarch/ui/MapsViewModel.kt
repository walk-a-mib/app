package com.example.demoapiarch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapiarch.model.CallResult
import com.example.demoapiarch.repository.path.IPathRepository
import com.example.demoapiarch.repository.place.IPlaceRepository
import com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository


class MapsViewModel(var placeRepository: IPlaceRepository,
                    var placesNearbyRepository: IPlacesNearbyRepository,
                    var pathRepository: IPathRepository
) : ViewModel() {
    val TAG: String = MapsViewModel::class.java.simpleName

    var place: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var placesNearby: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var paths: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
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

    fun fetchPath(referencePlaceId: String, destinationPlaceId: String, lastUpdate: Long) : MutableLiveData<CallResult> {
        paths = pathRepository.findPath(referencePlaceId, destinationPlaceId, lastUpdate)!!
        return paths
    }


}