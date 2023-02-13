package com.example.demoapiarch.source.path;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J&\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/example/demoapiarch/source/path/PathLocalDataSource;", "Lcom/example/demoapiarch/source/path/BasePathLocalDataSource;", "mapsRoomDatabase", "Lcom/example/demoapiarch/database/MapsRoomDatabase;", "(Lcom/example/demoapiarch/database/MapsRoomDatabase;)V", "edgeDao", "Lcom/example/demoapiarch/database/EdgeDao;", "getEdgeDao", "()Lcom/example/demoapiarch/database/EdgeDao;", "getMapsRoomDatabase", "()Lcom/example/demoapiarch/database/MapsRoomDatabase;", "pathDao", "Lcom/example/demoapiarch/database/PathDao;", "getPathDao", "()Lcom/example/demoapiarch/database/PathDao;", "placeDao", "Lcom/example/demoapiarch/database/PlaceDao;", "getPlaceDao", "()Lcom/example/demoapiarch/database/PlaceDao;", "getPath", "", "referenceId", "", "destinationId", "getPathLength", "", "steps", "", "Lcom/example/demoapiarch/model/path/Step;", "insertPath", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "app_debug"})
public final class PathLocalDataSource extends com.example.demoapiarch.source.path.BasePathLocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.PathDao pathDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.PlaceDao placeDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.EdgeDao edgeDao = null;
    
    public PathLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.MapsRoomDatabase getMapsRoomDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.PathDao getPathDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.PlaceDao getPlaceDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.EdgeDao getEdgeDao() {
        return null;
    }
    
    @java.lang.Override()
    public void getPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId) {
    }
    
    @java.lang.Override()
    public void insertPath(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.path.Step> steps) {
    }
    
    private final int getPathLength(java.util.List<com.example.demoapiarch.model.path.Step> steps) {
        return 0;
    }
}