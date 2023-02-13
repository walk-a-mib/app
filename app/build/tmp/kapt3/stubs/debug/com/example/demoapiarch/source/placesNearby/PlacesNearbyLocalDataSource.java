package com.example.demoapiarch.source.placesNearby;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/example/demoapiarch/source/placesNearby/PlacesNearbyLocalDataSource;", "Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyLocalDataSource;", "mapsRoomDatabase", "Lcom/example/demoapiarch/database/MapsRoomDatabase;", "(Lcom/example/demoapiarch/database/MapsRoomDatabase;)V", "getMapsRoomDatabase", "()Lcom/example/demoapiarch/database/MapsRoomDatabase;", "placeDao", "Lcom/example/demoapiarch/database/PlaceDao;", "getPlaceDao", "()Lcom/example/demoapiarch/database/PlaceDao;", "placeNearbyDao", "Lcom/example/demoapiarch/database/PlaceNearbyDao;", "getPlaceNearbyDao", "()Lcom/example/demoapiarch/database/PlaceNearbyDao;", "getPlacesNearby", "", "referenceId", "", "maxDistance", "", "insertPlacesNearby", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "neighbours", "", "Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "app_debug"})
public final class PlacesNearbyLocalDataSource extends com.example.demoapiarch.source.placesNearby.BasePlacesNearbyLocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.PlaceNearbyDao placeNearbyDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.database.PlaceDao placeDao = null;
    
    public PlacesNearbyLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.database.MapsRoomDatabase mapsRoomDatabase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.MapsRoomDatabase getMapsRoomDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.PlaceNearbyDao getPlaceNearbyDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.PlaceDao getPlaceDao() {
        return null;
    }
    
    @java.lang.Override()
    public void getPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, int maxDistance) {
    }
    
    @java.lang.Override()
    public void insertPlacesNearby(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, int maxDistance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> neighbours) {
    }
}