package com.example.walk_a_mib.repository.place

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.CallResult


interface IPlaceRepository {
    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<CallResult>?

    fun fetchAllPlaces(): MutableLiveData<CallResult>?
}