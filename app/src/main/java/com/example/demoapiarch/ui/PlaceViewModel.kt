package com.example.demoapiarch.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapiarch.domain.Coordinate
import com.example.demoapiarch.domain.GA
import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.place.PlaceResponse
import com.example.demoapiarch.place.PlaceResult
import com.example.demoapiarch.repository.IPlaceRepository


class PlaceViewModel(var placeRepository: IPlaceRepository) : ViewModel() {
    val TAG: String = PlaceViewModel::class.java.simpleName

    var place: MutableLiveData<PlaceResult> = MutableLiveData<PlaceResult>().apply { postValue(PlaceResult())}

    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<PlaceResult> {
        place = placeRepository.fetchPlace(placeId, lastUpdate)!!
        return place
    }
}