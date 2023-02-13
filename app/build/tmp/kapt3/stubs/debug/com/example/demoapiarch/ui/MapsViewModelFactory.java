package com.example.demoapiarch.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/demoapiarch/ui/MapsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "iPlaceRepository", "Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "iPlacesNearbyRepository", "Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "iPathRepository", "Lcom/example/demoapiarch/repository/path/IPathRepository;", "(Lcom/example/demoapiarch/repository/place/IPlaceRepository;Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;Lcom/example/demoapiarch/repository/path/IPathRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
public final class MapsViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    private final com.example.demoapiarch.repository.place.IPlaceRepository iPlaceRepository = null;
    private final com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository iPlacesNearbyRepository = null;
    private final com.example.demoapiarch.repository.path.IPathRepository iPathRepository = null;
    
    public MapsViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.place.IPlaceRepository iPlaceRepository, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository iPlacesNearbyRepository, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.path.IPathRepository iPathRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
}