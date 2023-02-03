package com.example.demoapiarch.model.path

import android.os.Parcelable
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
class PathBodyResponse(val distance: Int, val referencePlace: Node, val steps: List<Step>): Parcelable {

}