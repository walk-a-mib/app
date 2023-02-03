package com.example.demoapiarch.model.path

import android.os.Parcelable
import com.example.demoapiarch.domain.Node
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PathBodyResponse(val distance: Int,
                       @SerializedName("reference_place") val referencePlace: Node,
                       val steps: List<Step>): Parcelable