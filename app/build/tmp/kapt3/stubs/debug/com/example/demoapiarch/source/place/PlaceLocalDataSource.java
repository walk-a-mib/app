package com.example.demoapiarch.source.place;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/demoapiarch/source/place/PlaceLocalDataSource;", "Lcom/example/demoapiarch/source/place/BasePlaceLocalDataSource;", "mapsRoomDatabase", "Lcom/example/demoapiarch/database/MapsRoomDatabase;", "(Lcom/example/demoapiarch/database/MapsRoomDatabase;)V", "getMapsRoomDatabase", "()Lcom/example/demoapiarch/database/MapsRoomDatabase;", "placeDao", "Lcom/example/demoapiarch/database/PlaceDao;", "getPlaceDao", "()Lcom/example/demoapiarch/database/PlaceDao;", "getAllPlaces", "", "getPlace", "id", "", "insertPlace", "place", "Lcom/example/demoapiarch/domain/Node;", "insertPlaces", "places", "", "app_debug"})
public final class PlaceLocalDataSource extends com.example.demoapiarch.source.place.BasePlaceLocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.PlaceDao placeDao = null;
    
    public PlaceLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.MapsRoomDatabase getMapsRoomDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.PlaceDao getPlaceDao() {
        return null;
    }
    
    @java.lang.Override()
    public void getPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    @java.lang.Override()
    public void getAllPlaces() {
    }
    
    @java.lang.Override()
    public void insertPlace(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node place) {
    }
    
    @java.lang.Override()
    public void insertPlaces(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.domain.Node> places) {
    }
}