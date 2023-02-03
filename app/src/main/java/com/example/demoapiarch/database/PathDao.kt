package com.example.demoapiarch.database

import androidx.room.Dao
import androidx.room.Query
import com.example.demoapiarch.database.relationship.Pathway
import com.example.demoapiarch.domain.Path
import com.example.demoapiarch.model.path.Step

@Dao
interface PathDao: MapsDao<Pathway> {
    @Query("SELECT e.*, n.* FROM pathway " +
            "INNER JOIN node AS n ON intermediate_id = n.node_id " +
            "INNER JOIN edge AS e ON connecting_edge_id = e.edge_id " +
            "WHERE reference_id = :referenceId AND destination_id = :destinationId " +
            "ORDER BY order_number ASC")
    fun getPath(referenceId: String, destinationId: String): List<Step>?

}