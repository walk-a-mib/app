package com.example.demoapiarch.database

import androidx.room.Dao
import androidx.room.Query
import com.example.demoapiarch.database.relationship.Pathway
import com.example.demoapiarch.domain.Path
import com.example.demoapiarch.model.path.Step

@Dao
interface PathDao: MapsDao<Pathway> {
    @Query("SELECT n.id, n.label, n.type, n.name, n.description, n.lat, n.lon, n.alt, n.available, n.accessible, n.indoor, n.building, n.floor, " +
            "e.id, e.label, e.type, e.distance, e.available, e.accessible, e.indoor, e.building, e.floor FROM pathway " +
            "INNER JOIN node AS n ON intermediate_id = n.id " +
            "INNER JOIN edge AS e ON edge_id = e.id " +
            "WHERE reference_id = :referenceId AND destination_id = :destinationId " +
            "ORDER BY order_number ASC")
    fun getPath(referenceId: String, destinationId: String): List<Step>?

}