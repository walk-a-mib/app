package com.example.demoapiarch.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/example/demoapiarch/util/ServiceLocator;", "", "()V", "getDao", "Lcom/example/demoapiarch/database/MapsRoomDatabase;", "application", "Landroid/app/Application;", "getPathRepository", "Lcom/example/demoapiarch/repository/path/IPathRepository;", "getPlaceApiService", "Lcom/example/demoapiarch/service/MapsApiService;", "getPlaceRepository", "Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "getPlacesNearbyRepository", "Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "app_debug"})
public final class ServiceLocator {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapiarch.util.ServiceLocator INSTANCE = null;
    
    private ServiceLocator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.service.MapsApiService getPlaceApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.database.MapsRoomDatabase getDao(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.place.IPlaceRepository getPlaceRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository getPlacesNearbyRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.path.IPathRepository getPathRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
}