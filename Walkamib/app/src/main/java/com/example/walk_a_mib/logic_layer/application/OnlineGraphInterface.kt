package com.example.walk_a_mib.logic_layer.application

import com.example.walk_a_mib.logic_layer.domain.Graph

interface OnlineGraphInterface : GraphInterface {
    // Takes as input the number of the building,
    // returns the Graph object of that building
    fun getOfflineMapData(id: Int): Graph?
}