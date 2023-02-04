package com.example.walk_a_mib.model.path

import android.os.Parcelable
import com.example.walk_a_mib.logic_layer.domain.Node
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PathBodyResponse(val distance: Int,
                            @SerializedName("reference_place") val referencePlace: Node,
                            val steps: List<Step>): Parcelable