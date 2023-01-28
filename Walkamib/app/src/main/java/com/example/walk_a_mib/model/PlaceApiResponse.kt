package com.example.walk_a_mib.model

import com.example.walk_a_mib.logic_layer.domain.Node

class PlaceApiResponse(var status: String, place: Node) : PlaceResponse(place) {

    override fun toString(): String {
        return status + ";" + place.toString()
    }

}