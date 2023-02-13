package com.example.walk_a_mib.source.node

import com.example.walk_a_mib.source.callback.AllNodesCallback
import com.example.walk_a_mib.source.callback.PlaceCallback

abstract class BaseNodeRemoteDataSource() {
    var placeCallback: PlaceCallback? = null
    var allNodesCallback: AllNodesCallback? = null

    abstract fun getPlace(placeId : String)
    abstract fun getAllNodes()
}