package com.example.walk_a_mib.source.node

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.source.callback.AllNodesCallback
import com.example.walk_a_mib.source.callback.PlaceCallback

abstract class BaseNodeLocalDataSource() {
    var placeCallback: PlaceCallback? = null
    var allNodesCallback: AllNodesCallback? = null

    abstract fun getPlace(id: String)
    abstract fun getAllNodes()
    abstract fun insertPlace(place: Node)
    abstract fun insertNodes(nodes: List<Node>)
    abstract fun getPlacesFromNameKeyword(nameKeyword: String)
}