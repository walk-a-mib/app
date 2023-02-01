package com.example.demoapiarch.database

import androidx.room.*
import com.example.demoapiarch.domain.Node

@Dao
interface PlaceDao: MapsDao<Node> {

    @MapInfo(keyColumn = "id")
    @Query("SELECT * FROM node")
    fun getAll(): List<Node>?

    @Query("SELECT * FROM node WHERE id = :id")
    fun getPlace(id: String): Node?

}