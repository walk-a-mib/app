package com.example.walk_a_mib.database.relationship

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
            parentColumns = ["id"]),
        ForeignKey(
            entity = Node::class,
            childColumns = ["neighbour_id"],
            parentColumns = ["id"])
    ])
class Proximity(@NonNull @ColumnInfo(name = "reference_id") var referenceId: String,
                @ColumnInfo(name = "neighbour_id") var neighborId: String,
                @NonNull @ColumnInfo(name = "distance") var distance: Int) : Parcelable {
}