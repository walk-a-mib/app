package com.example.demoapiarch.model.path

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.demoapiarch.domain.Edge
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class Step(
    @Embedded val node: Node,
    @Embedded val edge: Edge): Parcelable