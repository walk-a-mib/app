package com.example.walk_a_mib.repository.node

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.CallResult


interface INodeRepository {
    fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<CallResult>?

    fun fetchAllNodes(lastUpdate: Long): MutableLiveData<CallResult>?

    fun searchPlaceFromNameKeyword(lastUpdate: Long, keyword: String): MutableLiveData<CallResult>?
}