package com.example.demoapiarch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.demoapiarch.repository.path.IPathRepository
import com.example.demoapiarch.repository.place.IPlaceRepository
import com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository

class MapsViewModelFactory(private val iPlaceRepository: IPlaceRepository,
                           private val iPlacesNearbyRepository: IPlacesNearbyRepository,
                           private val iPathRepository: IPathRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapsViewModel(iPlaceRepository, iPlacesNearbyRepository, iPathRepository) as T
    }
}