package com.example.demoapiarch.domain

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
class Edge(
    @PrimaryKey(autoGenerate = false) var id: String,
    var label: String,
    var type: Int,
    var distance: Int,
    @Embedded var ga: GA): Parcelable {

}