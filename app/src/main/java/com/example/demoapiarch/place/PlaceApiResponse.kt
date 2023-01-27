package com.example.demoapiarch.place

import android.os.Parcel
import com.example.demoapiarch.domain.Coordinate
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

class PlaceApiResponse(var status: String, place: Node) : PlaceResponse(place) {

    override fun toString(): String {
        return status + ";" + place.toString()
    }

}