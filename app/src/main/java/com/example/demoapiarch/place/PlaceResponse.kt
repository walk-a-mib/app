package com.example.demoapiarch.place

import android.os.Parcel
import android.os.Parcelable
import com.example.demoapiarch.domain.Node

open class PlaceResponse(var place: Node?): Parcelable {

    constructor(parcel: Parcel) : this(parcel.readParcelable(Node::class.java.classLoader)) {
        place = parcel.readTypedObject(Node.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedObject(this.place, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    open fun readFromParcel(s: Parcel) {
        this.place = s.readTypedObject(Node.CREATOR)!!
    }

    companion object CREATOR : Parcelable.Creator<PlaceResponse> {
        override fun createFromParcel(parcel: Parcel): PlaceResponse {
            return PlaceResponse(parcel)
        }

        override fun newArray(size: Int): Array<PlaceResponse?> {
            return arrayOfNulls(size)
        }
    }

}