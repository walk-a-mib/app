package com.example.walk_a_mib.model.place

import android.os.Parcelable
import com.example.walk_a_mib.logic_layer.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
open class PlaceBodyResponse(val place: Node): Parcelable {
}