package com.example.demoapiarch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapiarch.repository.place.IPlaceRepository
import com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository

class PlaceViewModelFactory(private val iPlaceRepository: IPlaceRepository,
                            private val iPlacesNearbyRepository: IPlacesNearbyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlaceViewModel(iPlaceRepository, iPlacesNearbyRepository) as T
    }
}