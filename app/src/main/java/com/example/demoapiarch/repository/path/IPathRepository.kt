package com.example.demoapiarch.repository.path

import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.model.CallResult

interface IPathRepository {
    fun findPath(referencePlaceId: String, destinationPlaceId: String, lastUpdate: Long): MutableLiveData<CallResult>?
}