package com.example.walk_a_mib.logic_layer.domain

class Edge {
    var type = 0
    private var id = 0
    var distance = 0.0
    var a: Coordinate? = null
    var b: Coordinate? = null
    fun typeString(): String {
        return EdgeType.getTypeString(id)
    }
}