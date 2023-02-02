package com.example.walk_a_mib.database

import androidx.room.*
import com.example.walk_a_mib.logic_layer.domain.Node

@Dao
interface PlaceDao: MapsDao<Node> {

    @MapInfo(keyColumn = "id")
    @Query("SELECT * FROM node")
    fun getAll(): List<Node>?

    @Query("SELECT * FROM node WHERE id = :id")
    fun getPlace(id: String): Node?

}