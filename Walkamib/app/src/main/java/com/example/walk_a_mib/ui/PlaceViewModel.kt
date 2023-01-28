package com.example.walk_a_mib.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.walk_a_mib.model.PlaceResult
import com.example.walk_a_mib.repository.IPlaceRepository


class PlaceViewModel(var placeRepository: IPlaceRepository) : ViewModel() {
    val TAG: String = PlaceViewModel::class.java.simpleName

    var place: MutableLiveData<PlaceResult> = MutableLiveData<PlaceResult>().apply { postValue(PlaceResult())}

    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<PlaceResult> {
        place = placeRepository.fetchPlace(placeId, lastUpdate)!!
        return place
    }
}