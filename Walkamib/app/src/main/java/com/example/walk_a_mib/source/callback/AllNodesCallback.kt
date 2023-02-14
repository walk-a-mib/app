package com.example.walk_a_mib.source.callback

import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.node.AllNodesBodyResponse
import com.example.walk_a_mib.source.MapsCallback

interface AllNodesCallback: MapsCallback {
    fun onSuccessFromLocalAllNodes(nodes: List<Node>?)

    fun onSuccessFromRemoteAllNodes(apiResponse: GenericApiResponse<AllNodesBodyResponse>,
                                    lastUpdate: Long)

    fun onSuccessFromLocalNodesFromKeyword(nodes: List<Node>?)
}