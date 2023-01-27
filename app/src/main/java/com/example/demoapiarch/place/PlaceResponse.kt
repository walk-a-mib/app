package com.example.demoapiarch.place

import android.os.Parcel
import android.os.Parcelable
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
open class PlaceResponse(var place: Node?) : Parcelable {

}