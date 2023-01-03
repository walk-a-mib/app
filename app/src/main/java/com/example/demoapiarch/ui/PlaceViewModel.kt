package com.example.demoapiarch.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapiarch.place.PlaceResult
import com.example.demoapiarch.repository.IPlaceRepository


class PlaceViewModel(var placeRepository: IPlaceRepository) : ViewModel() {
    val TAG: String = PlaceViewModel::class.java.simpleName

    //var place: MutableLiveData<PlaceResult> = MutableLiveData<PlaceResult>().apply { postValue(PlaceResult())}
    val place: MutableLiveData<PlaceResult> by lazy {
        MutableLiveData<PlaceResult>()
    }

    fun fetchPlace(placeId: String, lastUpdate: Long) {
        place.value = placeRepository.fetchPlace(placeId, lastUpdate)?.value
    }

    //fun getPlace(placeId: String, lastUpdate: Long) { //: MutableLiveData<PlaceResult>? {
    //    Log.d("MAIN", place?.value.toString())
    //    Log.d("MAIN", placeId)
    //
    //    fetchPlace(placeId, lastUpdate)
    //    Log.d("MAIN", place?.value.toString())
    //    //return place
    //}

    //private fun fetchPlace(placeId: String, lastUpdate: Long) {
    //    var s = placeRepository.fetchPlace(placeId, lastUpdate)?.value
    //    Log.d("MAIN", s.toString())
    //    place?.value = s!!
    //}




}