package com.example.demoapiarch.repository.place

import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.model.CallResult


interface IPlaceRepository {
    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<CallResult>?

    fun fetchAllPlaces(): MutableLiveData<CallResult>?
}