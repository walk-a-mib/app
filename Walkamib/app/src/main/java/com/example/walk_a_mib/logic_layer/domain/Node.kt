package com.example.walk_a_mib.logic_layer.domain

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.lang.Math.toDegrees
import kotlin.math.*

@Parcelize
@Entity
class Node(@ColumnInfo(name = "node_id") @PrimaryKey(autoGenerate = false) var id: String,
           @ColumnInfo(name = "node_label") var label: String,
           @ColumnInfo(name = "node_type") var type: Int,
           var name: String,
           var description: String,
           @Embedded(prefix = "node") var position: Coordinate,
           @Embedded(prefix = "node") var ga: GA) : Parcelable {

    override fun toString(): String {
        return "$id;$label;$name;$description;$position;$ga"
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
        return (angle3 * 7 / 360).roundToInt()
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

}