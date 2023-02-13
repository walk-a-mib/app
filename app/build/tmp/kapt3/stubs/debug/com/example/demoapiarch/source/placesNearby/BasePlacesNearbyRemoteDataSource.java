package com.example.demoapiarch.source.placesNearby;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyRemoteDataSource;", "", "()V", "placeNearbyCallback", "Lcom/example/demoapiarch/source/callbacks/PlacesNearbyCallback;", "getPlaceNearbyCallback", "()Lcom/example/demoapiarch/source/callbacks/PlacesNearbyCallback;", "setPlaceNearbyCallback", "(Lcom/example/demoapiarch/source/callbacks/PlacesNearbyCallback;)V", "getPlacesNearby", "", "referenceId", "", "maxDistance", "", "app_debug"})
public abstract class BasePlacesNearbyRemoteDataSource {
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapiarch.source.callbacks.PlacesNearbyCallback placeNearbyCallback;
    
    public BasePlacesNearbyRemoteDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.demoapiarch.source.callbacks.PlacesNearbyCallback getPlaceNearbyCallback() {
        return null;
    }
    
    public final void setPlaceNearbyCallback(@org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.source.callbacks.PlacesNearbyCallback p0) {
    }
    
    public abstract void getPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, int maxDistance);
}