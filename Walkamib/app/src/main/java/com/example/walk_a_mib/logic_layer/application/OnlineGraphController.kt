package com.example.walk_a_mib.logic_layer.application

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.logic_layer.domain.Path
import com.example.walk_a_mib.logic_layer.domain.Graph

object OnlineGraphController : OnlineGraphInterface {
    override fun getOfflineMapData(id: Int): Graph? {
        TODO("Not yet implemented")
    }

    override fun getPath(start: Node?, end: Node?): Path? {
        TODO("Not yet implemented")
    }

    override fun getNearestPlace(position: Node?, type: String?): Node? {
        TODO("Not yet implemented")
    }

    override fun getNearbyPlace(position: Node?, range: Int): ArrayList<Node?>? {
        TODO("Not yet implemented")
    }

}