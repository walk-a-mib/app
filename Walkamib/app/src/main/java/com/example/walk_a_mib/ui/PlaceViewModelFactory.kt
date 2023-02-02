package com.example.walk_a_mib.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walk_a_mib.repository.place.IPlaceRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository

class PlaceViewModelFactory(private val iPlaceRepository: IPlaceRepository,
                            private val iPlacesNearbyRepository: IPlacesNearbyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlaceViewModel(iPlaceRepository, iPlacesNearbyRepository) as T
    }
}