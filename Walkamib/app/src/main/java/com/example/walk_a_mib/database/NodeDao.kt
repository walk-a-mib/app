package com.example.walk_a_mib.database

import androidx.room.*
import com.example.demoapiarch.database.MapsDao
import com.example.walk_a_mib.logic_layer.domain.Node

@Dao
interface NodeDao: MapsDao<Node> {

    @MapInfo(keyColumn = "node_id")
    @Query("SELECT * FROM node")
    fun getAllNodes(): List<Node>?

    @Query("SELECT * FROM node WHERE node_id = :id")
    fun getPlace(id: String): Node?

    @Query("SELECT * FROM node WHERE UPPER(name) LIKE UPPER('%' || :nameKeyword || '%')")
    fun getPlacesFromNameKeyword(nameKeyword: String): List<Node>?

}