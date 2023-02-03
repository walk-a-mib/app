package com.example.demoapiarch.database.relationship

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    primaryKeys = ["reference_id", "neighbour_id"],
    foreignKeys = [
        ForeignKey(
            entity = Node::class,
            childColumns = ["reference_id"],
            parentColumns = ["node_id"]),
        ForeignKey(
            entity = Node::class,
            childColumns = ["neighbour_id"],
            parentColumns = ["node_id"])
    ])
class Proximity(@ColumnInfo(name = "reference_id") var referenceId: String,
                @ColumnInfo(name = "neighbour_id") var neighborId: String,
                @ColumnInfo(name = "distance") var distance: Int) : Parcelable