package com.example.walk_a_mib.database

import androidx.room.Dao
import com.example.demoapiarch.database.MapsDao
import com.example.walk_a_mib.logic_layer.domain.Edge

@Dao
interface EdgeDao: MapsDao<Edge> {
}