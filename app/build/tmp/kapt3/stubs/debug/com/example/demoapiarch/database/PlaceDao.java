package com.example.demoapiarch.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\'J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/demoapiarch/database/PlaceDao;", "Lcom/example/demoapiarch/database/MapsDao;", "Lcom/example/demoapiarch/domain/Node;", "getAllPlaces", "", "getPlace", "id", "", "app_debug"})
public abstract interface PlaceDao extends com.example.demoapiarch.database.MapsDao<com.example.demoapiarch.domain.Node> {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM node")
    @androidx.room.MapInfo(keyColumn = "node_id")
    public abstract java.util.List<com.example.demoapiarch.domain.Node> getAllPlaces();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM node WHERE node_id = :id")
    public abstract com.example.demoapiarch.domain.Node getPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
}