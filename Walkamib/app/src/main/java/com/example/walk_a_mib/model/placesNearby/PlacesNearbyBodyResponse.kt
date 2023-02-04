package com.example.walk_a_mib.model.placesNearby

import android.os.Parcelable
import com.example.walk_a_mib.logic_layer.domain.Node
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlacesNearbyBodyResponse(val referencePlace: Node,
                                    val placesNearby: List<Neighbour>): Parcelable