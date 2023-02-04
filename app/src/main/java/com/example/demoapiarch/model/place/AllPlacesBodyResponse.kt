package com.example.demoapiarch.model.place

import com.example.demoapiarch.domain.Node
import java.io.Serializable

class AllPlacesBodyResponse(val places: List<Node>): Serializable {
}