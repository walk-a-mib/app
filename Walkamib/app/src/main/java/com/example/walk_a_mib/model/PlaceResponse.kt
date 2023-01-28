package com.example.walk_a_mib.model

import android.os.Parcelable
import com.example.walk_a_mib.logic_layer.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
open class PlaceResponse(var place: Node?) : Parcelable {

}