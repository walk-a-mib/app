package com.example.demoapiarch.domain

import android.os.Parcel
import android.os.ParcelFileDescriptor
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.Math.toDegrees
import kotlin.math.*

@Entity
class Node() : Parcelable {

    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = false)
    lateinit var id: String

    @SerializedName("label")
    @Expose
    var label: String = ""

    //var type: Int = 0

    //manca l'altro id

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @Embedded
    @SerializedName("position")
    @Expose
    var position: Coordinate = Coordinate(0.0, 0.0, 0.0)

    @Embedded
    @SerializedName("ga")
    @Expose
    var ga: GA? = null

    @Ignore
    constructor(id: String, label: String, name: String, description: String?, position: Coordinate, ga: GA): this() {
        this.id = id
        this.label = label
        this.name = name
        this.description = description
        this.position = position
        this.ga = ga
    }

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()!!
        label = parcel.readString()!!
        //type = parcel.readInt()
        name = parcel.readString()
        description = parcel.readString()
        position = parcel.readParcelable(Coordinate::class.java.classLoader)!!
        ga = parcel.readParcelable(GA::class.java.classLoader)
    }


    // helpers
    private fun Double.toRadian() = this * Math.PI / 180.0

    //fun typeString(): String? {
    //    return NodeType.getTypeString(id)
    //}

    // Takes a provenience node and a destination node as parameter,
    // returns the RELATIVE direction (considering the arriving direction).
    // Note that the final direction is given as follows:
    // N: 0
    // NE: 1
    // E: 2
    // SE: 3
    // S: 4
    // SW: 5
    // W: 6
    // NW: 7
    fun getPathDirection(origin : Node, destination : Node): Int {
        val angle1 = origin.getHeading(this)
        val angle2 = this.getHeading(destination)
        val angle3 = ((angle2 - angle1) + 360) % 360
        val direction = (angle3 * 7 / 360).roundToInt()
        return direction
    }

    // Takes a destination node,
    // returns the bearing
    fun getHeading(destination : Node): Double {
        val rLat1 = this.position.lat.toRadian()
        val rLat2 = destination.position.lat.toRadian()
        val rLon1 = this.position.lon.toRadian()
        val rLon2 = destination.position.lon.toRadian()

        val rDeltaLon = rLon2 - rLon1
        val y = sin(rDeltaLon) * cos(rLat2)
        val x = cos(rLat1) * sin(rLat2) - (sin(rLat1) * cos(rLat2) * cos(rDeltaLon))
        val rBearing = atan2(y, x)
        val dBearing = (toDegrees(rBearing) + 360) % 360
        return dBearing
    }

    override fun toString(): String {
        return id + ";" + label
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(label)
        //parcel.writeInt(type)
        //parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Node> {
        override fun createFromParcel(parcel: Parcel): Node {
            return Node(parcel)
        }

        override fun newArray(size: Int): Array<Node?> {
            return arrayOfNulls(size)
        }
    }


}