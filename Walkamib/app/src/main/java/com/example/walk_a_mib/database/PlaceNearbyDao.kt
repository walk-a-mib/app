package com.example.walk_a_mib.database

import androidx.room.*
import com.example.demoapiarch.database.MapsDao
import com.example.walk_a_mib.database.relationship.Proximity
import com.example.walk_a_mib.model.placesNearby.Neighbour

@Dao
interface PlaceNearbyDao: MapsDao<Proximity> {
    @Query("SELECT n.*, pr.distance FROM node AS n " +
            "INNER JOIN proximity AS pr ON node_id = pr.neighbour_id " +
            "WHERE pr.reference_id = :referenceId AND distance <= :maxDistance")
    fun getPlacesNearby(referenceId: String, maxDistance: Int): List<Neighbour>?
}