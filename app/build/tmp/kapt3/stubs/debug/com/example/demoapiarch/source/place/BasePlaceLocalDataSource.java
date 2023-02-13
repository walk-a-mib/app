package com.example.demoapiarch.source.place;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/example/demoapiarch/source/place/BasePlaceLocalDataSource;", "", "()V", "allPlacesCallback", "Lcom/example/demoapiarch/source/callbacks/AllPlacesCallback;", "getAllPlacesCallback", "()Lcom/example/demoapiarch/source/callbacks/AllPlacesCallback;", "setAllPlacesCallback", "(Lcom/example/demoapiarch/source/callbacks/AllPlacesCallback;)V", "placeCallback", "Lcom/example/demoapiarch/source/callbacks/PlaceCallback;", "getPlaceCallback", "()Lcom/example/demoapiarch/source/callbacks/PlaceCallback;", "setPlaceCallback", "(Lcom/example/demoapiarch/source/callbacks/PlaceCallback;)V", "getAllPlaces", "", "getPlace", "id", "", "insertPlace", "place", "Lcom/example/demoapiarch/domain/Node;", "insertPlaces", "places", "", "app_debug"})
public abstract class BasePlaceLocalDataSource {
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapiarch.source.callbacks.PlaceCallback placeCallback;
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapiarch.source.callbacks.AllPlacesCallback allPlacesCallback;
    
    public BasePlaceLocalDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.demoapiarch.source.callbacks.PlaceCallback getPlaceCallback() {
        return null;
    }
    
    public final void setPlaceCallback(@org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.source.callbacks.PlaceCallback p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.demoapiarch.source.callbacks.AllPlacesCallback getAllPlacesCallback() {
        return null;
    }
    
    public final void setAllPlacesCallback(@org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.source.callbacks.AllPlacesCallback p0) {
    }
    
    public abstract void getPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    public abstract void getAllPlaces();
    
    public abstract void insertPlace(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node place);
    
    public abstract void insertPlaces(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.domain.Node> places);
}