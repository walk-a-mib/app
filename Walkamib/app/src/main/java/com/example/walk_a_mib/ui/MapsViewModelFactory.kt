package com.example.walk_a_mib.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.repository.node.INodeRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository

class MapsViewModelFactory(private val iPlaceRepository: INodeRepository,
                           private val iPlacesNearbyRepository: IPlacesNearbyRepository,
                           private val iPathRepository: IPathRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MapsViewModel(iPlaceRepository, iPlacesNearbyRepository, iPathRepository) as T
    }
}