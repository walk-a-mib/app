package com.example.demoapiarch.model.placesNearby

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class Neighbour(@Embedded val place: Node,
                @ColumnInfo(name = "distance") val distance: Int): Parcelable {
    override fun toString(): String {
        return "${place.toString()};$distance"
    }
}