package com.example.walk_a_mib.model.place
import com.example.walk_a_mib.logic_layer.domain.Node
import java.io.Serializable

class AllPlacesBodyResponse(val places: List<Node>): Serializable {
}