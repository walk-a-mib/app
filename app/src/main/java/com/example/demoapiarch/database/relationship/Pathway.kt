package com.example.demoapiarch.database.relationship

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.demoapiarch.domain.Edge
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Node::class,
            childColumns = ["reference_id"],
            parentColumns = ["id"]),
        ForeignKey(
            entity = Node::class,
            childColumns = ["destination_id"],
            parentColumns = ["id"]),
        ForeignKey(
            entity = Node::class,
            childColumns = ["intermediate_id"],
            parentColumns = ["id"]),
        ForeignKey(
            entity = Edge::class,
            childColumns = ["edge_id"],
            parentColumns = ["id"]),
    ])
class Pathway(
    @ColumnInfo(name = "reference_id") var referenceId: String,
    @ColumnInfo(name = "destination_id") var destinationId: String,
    @ColumnInfo(name = "intermediate_id") var intermediateId: String,
    @ColumnInfo(name = "edge_id") var edgeId: String,
    @ColumnInfo(name = "order_number") var orderNumber: Int) : Parcelable {

    @PrimaryKey(autoGenerate = true) var id: Int = 0
}