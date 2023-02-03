package com.example.demoapiarch.database

import androidx.room.Dao
import androidx.room.MapInfo
import androidx.room.Query
import com.example.demoapiarch.domain.Edge
import com.example.demoapiarch.domain.Node

@Dao
interface EdgeDao: MapsDao<Edge> {
}