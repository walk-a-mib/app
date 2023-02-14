package com.example.walk_a_mib.repository.path

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.path.PathOptionalFilters

interface IPathRepository {
    fun findPath(
        referencePlaceId: String,
        destinationPlaceId: String,
        optionalFilters: PathOptionalFilters,
        lastUpdate: Long
    ): MutableLiveData<CallResult>?
}