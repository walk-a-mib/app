package com.example.walk_a_mib.repository.path

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.CallResult

interface IPathRepository {
    fun findPath(
        referencePlaceId: String,
        destinationPlaceId: String,
        lastUpdate: Long
    ): MutableLiveData<CallResult>?
}