package com.example.walk_a_mib.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walk_a_mib.repository.IPlaceRepository

class PlaceViewModelFactory(private val iPlaceRepository: IPlaceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlaceViewModel(iPlaceRepository) as T
    }
}