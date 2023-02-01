package com.example.demoapiarch.repository.placesNearby

import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.model.CallResult

interface IPlacesNearbyRepository {
    fun fetchPlacesNearby(referencePlaceId: String, maxDistance: Int, lastUpdate: Long): MutableLiveData<CallResult>?
}