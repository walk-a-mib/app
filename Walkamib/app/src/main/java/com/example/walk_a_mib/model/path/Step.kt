package com.example.walk_a_mib.model.path

import android.os.Parcelable
import androidx.room.Embedded
import com.example.walk_a_mib.logic_layer.domain.Edge
import com.example.walk_a_mib.logic_layer.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class Step(
    @Embedded val edge: Edge,
    @Embedded val node: Node
): Parcelable //@Embedded(prefix = "edge_bean")