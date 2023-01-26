package com.example.demoapiarch.domain
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.math.*

class Coordinate() : Parcelable {
    @SerializedName("lat")
    @Expose
    var lat: Double = 0.0
    @SerializedName("lon")
    @Expose
    var lon: Double = 0.0
    @SerializedName("alt")
    @Expose
    var alt: Double = 0.0

    constructor(parcel: Parcel) : this() {
        lat = parcel.readDouble()
        lon = parcel.readDouble()
        alt = parcel.readDouble()
    }

    @Ignore
    constructor(lat: Double, lon: Double, alt: Double) : this() {
        this.lat = lat;
        this.lon = lon;
        this.alt = lat;
    }

    fun distance(b: Coordinate): Double {
        val r = 6371
        val latDistance = Math.toRadians(b.lat - this.lat)
        val lonDistance = Math.toRadians(b.lon - this.lon)
        val k = (sin(latDistance / 2) * sin(latDistance / 2)
                + (cos(Math.toRadians(this.lat))
                * cos(Math.toRadians(b.lat))
                * sin(lonDistance / 2) * sin(lonDistance / 2)))
        val c = 2 * atan2(sqrt(k), sqrt(1 - k))
        var distance = r * c * 1000
        val height = this.alt - b.alt
        distance = distance.pow(2.0) + height.pow(2.0)
        return sqrt(distance)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat)
        parcel.writeDouble(lon)
        parcel.writeDouble(alt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coordinate> {
        override fun createFromParcel(parcel: Parcel): Coordinate {
            return Coordinate(parcel)
        }

        override fun newArray(size: Int): Array<Coordinate?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "COORDINATE(" + lat + ";" + lon + ";" + alt + ")";
    }
}