package com.example.walk_a_mib.logic_layer.domain

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
class Edge(
    @ColumnInfo(name = "edge_id") @PrimaryKey(autoGenerate = false) var id: String,
    @ColumnInfo(name = "edge_label") var label: String,
    @ColumnInfo(name = "edge_type") var type: Int,
    var distance: Int,
    @Embedded(prefix = "edge") var ga: GA): Parcelable {
    override fun toString(): String {
        return "EDGE($id;$label;$type;$distance;$ga)"
    }

    fun typeString(): String {
        return EdgeType.getTypeString(id.toInt())
    }

    }