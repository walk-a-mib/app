package com.example.demoapiarch.repository

import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.place.PlaceResult


interface IPlaceRepository {
    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<PlaceResult>?
}