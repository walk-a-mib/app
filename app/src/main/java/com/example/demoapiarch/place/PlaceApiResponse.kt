package com.example.demoapiarch.place

import android.os.Parcel
import com.example.demoapiarch.domain.Coordinate
import com.example.demoapiarch.domain.Node


class PlaceApiResponse(var status: String, place: Node) : PlaceResponse(place) {

    //constructor(parcel: Parcel) : super(parcel)  {
    //    status = parcel.readString()!!
    //    place = parcel.readParcelable(Node::class.java.classLoader)!!
    //}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        parcel.writeString(status)
    }

    override fun readFromParcel(s: Parcel) {
        super.readFromParcel(s)
        status = s.readString()!!
    }

    override fun toString(): String {
        return status + ";" + place.toString()
    }

}