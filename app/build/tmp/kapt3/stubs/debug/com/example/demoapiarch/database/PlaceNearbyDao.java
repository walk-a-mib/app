package com.example.demoapiarch.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/example/demoapiarch/database/PlaceNearbyDao;", "Lcom/example/demoapiarch/database/MapsDao;", "Lcom/example/demoapiarch/database/relationship/Proximity;", "getPlacesNearby", "", "Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "referenceId", "", "maxDistance", "", "app_debug"})
public abstract interface PlaceNearbyDao extends com.example.demoapiarch.database.MapsDao<com.example.demoapiarch.database.relationship.Proximity> {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT n.*, pr.distance FROM node AS n INNER JOIN proximity AS pr ON node_id = pr.neighbour_id WHERE pr.reference_id = :referenceId AND distance <= :maxDistance")
    public abstract java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> getPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, int maxDistance);
}