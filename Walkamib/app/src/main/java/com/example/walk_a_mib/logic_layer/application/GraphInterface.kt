package com.example.walk_a_mib.logic_layer.application

import com.example.walk_a_mib.logic_layer.application.GraphInterface
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.logic_layer.domain.Path

interface GraphInterface {
    // Takes as input an initial and a final node,
    // returns the Path object
    fun getPath(start: Node?, end: Node?): Path?

    // Takes as input a position node and the desired type,
    // returns the nearest Node of that type
    fun getNearestPlace(position: Node?, type: String?): Node?

    // Takes as input a position node and the range,
    // returns the list of nearby places
    fun getNearbyPlace(position: Node?, range: Int): ArrayList<Node?>?


}