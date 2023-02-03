package com.example.demoapiarch.model.place

import android.os.Parcelable
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaceBodyResponse(val place: Node): Parcelable