package com.example.walk_a_mib.repository.placesNearby

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.CallResult

interface IPlacesNearbyRepository {
    fun fetchPlacesNearby(referencePlaceId: String, maxDistance: Int, lastUpdate: Long): MutableLiveData<CallResult>?
}