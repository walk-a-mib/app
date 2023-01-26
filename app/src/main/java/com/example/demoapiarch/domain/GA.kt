package com.example.demoapiarch.domain

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GA() : Parcelable {
    @SerializedName("available")
    @Expose
    var available = false
    @SerializedName("accessible")
    @Expose
    var accessible = false
    @SerializedName("indoor")
    @Expose
    var indoor = false
    @SerializedName("building")
    @Expose
    var building = 0
    @SerializedName("floor")
    @Expose
    var floor = 0

    var image: String? = null

    override fun toString(): String {
        return "GA(" + available + ";" + accessible + ";" + indoor + ";" + building + ";" + floor + ")";
    }

    @Ignore
    constructor(available: Boolean, accessible: Boolean, indoor: Boolean, building: Int) : this() {
        this.available = available;
        this.accessible = accessible;
        this.indoor = indoor;
        this.building = building;
    }

    constructor(parcel: Parcel) : this() {
        available = parcel.readByte() != 0.toByte()
        accessible = parcel.readByte() != 0.toByte()
        indoor = parcel.readByte() != 0.toByte()
        building = parcel.readInt()
        floor = parcel.readInt()
        image = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (available) 1 else 0)
        parcel.writeByte(if (accessible) 1 else 0)
        parcel.writeByte(if (indoor) 1 else 0)
        parcel.writeInt(building)
        parcel.writeInt(floor)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GA> {
        override fun createFromParcel(parcel: Parcel): GA {
            return GA(parcel)
        }

        override fun newArray(size: Int): Array<GA?> {
            return arrayOfNulls(size)
        }
    }
}