package com.example.walk_a_mib.logic_layer.application

import com.example.demoapiarch.domain.Path
import com.example.walk_a_mib.logic_layer.domain.Graph
import com.example.walk_a_mib.logic_layer.domain.Node

object OfflineGraphController : OfflineGraphInterface {

    val savedGraphMap : Map<Int?, Graph?>? = null

    override fun getPath(start: Node?, end: Node?): Path? {
        TODO(reason = "Not yet implemented")
    }

    override fun getNearestPlace(position: Node?, type: String?): Node? {
        TODO(reason = "Not yet implemented")
    }

    override fun getNearbyPlace(position: Node?, range: Int): ArrayList<Node?>? {
        TODO(reason = "Not yet implemented")
    }

    override fun getSavedGraphMap(filePath: String?): Map<Int?, Graph?>?{
        TODO(reason = "Not yet implemented")
    }

    override fun saveGraphMap(graphMap: Map<Int?, Graph?>?, filePath: String?){
        TODO(reason = "Not yet implemented")
    }
}