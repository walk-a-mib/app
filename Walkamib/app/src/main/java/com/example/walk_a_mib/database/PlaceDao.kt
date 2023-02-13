package com.example.walk_a_mib.database

import androidx.room.*
import com.example.demoapiarch.database.MapsDao
import com.example.walk_a_mib.logic_layer.domain.Node

@Dao
interface PlaceDao: MapsDao<Node> {

    @MapInfo(keyColumn = "node_id")
    @Query("SELECT * FROM node")
    fun getAllPlaces(): List<Node>?

    @Query("SELECT * FROM node WHERE node_id = :id")
    fun getPlace(id: String): Node?

}