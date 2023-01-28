package com.example.walk_a_mib.repository

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.PlaceResult


interface IPlaceRepository {
    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<PlaceResult>?
}