package com.example.walk_a_mib.model.node
import com.example.walk_a_mib.logic_layer.domain.Node
import java.io.Serializable

class AllNodesBodyResponse(val nodes: List<Node>): Serializable {
}