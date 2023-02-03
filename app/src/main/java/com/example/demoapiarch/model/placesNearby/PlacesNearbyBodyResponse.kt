package com.example.demoapiarch.model.placesNearby

import android.os.Parcelable
import com.example.demoapiarch.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlacesNearbyBodyResponse(val referencePlace: Node, val placesNearby: List<Neighbour>): Parcelable {
}