package com.example.walk_a_mib.logic_layer.application

import com.example.walk_a_mib.logic_layer.domain.Graph

interface OfflineGraphInterface : GraphInterface {
    // Takes as input the name of the file where the graphs are saved,
    // returns the map of Graph objects
    fun getSavedGraphMap(filePath: String?): Map<Int?, Graph?>?

    // Takes as input the map of Graph objects and the file path,
    // saves in the file the graphMap
    fun saveGraphMap(graphMap: Map<Int?, Graph?>?, filePath: String?)
}