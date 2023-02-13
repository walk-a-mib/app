package com.example.demoapiarch.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010*\u001a\u00020+J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010*\u001a\u00020+J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u00100\u001a\u00020\n2\u0006\u0010*\u001a\u00020+J$\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u00102\u001a\u0002032\u0006\u0010*\u001a\u00020+R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u00064"}, d2 = {"Lcom/example/demoapiarch/ui/MapsViewModel;", "Landroidx/lifecycle/ViewModel;", "placeRepository", "Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "placesNearbyRepository", "Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "pathRepository", "Lcom/example/demoapiarch/repository/path/IPathRepository;", "(Lcom/example/demoapiarch/repository/place/IPlaceRepository;Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;Lcom/example/demoapiarch/repository/path/IPathRepository;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allPlaces", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "getAllPlaces", "()Landroidx/lifecycle/MutableLiveData;", "setAllPlaces", "(Landroidx/lifecycle/MutableLiveData;)V", "getPathRepository", "()Lcom/example/demoapiarch/repository/path/IPathRepository;", "setPathRepository", "(Lcom/example/demoapiarch/repository/path/IPathRepository;)V", "paths", "getPaths", "setPaths", "place", "getPlace", "setPlace", "getPlaceRepository", "()Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "setPlaceRepository", "(Lcom/example/demoapiarch/repository/place/IPlaceRepository;)V", "placesNearby", "getPlacesNearby", "setPlacesNearby", "getPlacesNearbyRepository", "()Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "setPlacesNearbyRepository", "(Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;)V", "fetchAllPlaces", "lastUpdate", "", "fetchPath", "referencePlaceId", "destinationPlaceId", "fetchPlace", "placeId", "fetchPlacesNearby", "maxDistance", "", "app_debug"})
public final class MapsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.example.demoapiarch.repository.place.IPlaceRepository placeRepository;
    @org.jetbrains.annotations.NotNull()
    private com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository placesNearbyRepository;
    @org.jetbrains.annotations.NotNull()
    private com.example.demoapiarch.repository.path.IPathRepository pathRepository;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> place;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> allPlaces;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> placesNearby;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> paths;
    
    public MapsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.place.IPlaceRepository placeRepository, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository placesNearbyRepository, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.path.IPathRepository pathRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.place.IPlaceRepository getPlaceRepository() {
        return null;
    }
    
    public final void setPlaceRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.place.IPlaceRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository getPlacesNearbyRepository() {
        return null;
    }
    
    public final void setPlacesNearbyRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.repository.path.IPathRepository getPathRepository() {
        return null;
    }
    
    public final void setPathRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.repository.path.IPathRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getPlace() {
        return null;
    }
    
    public final void setPlace(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getAllPlaces() {
        return null;
    }
    
    public final void setAllPlaces(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getPlacesNearby() {
        return null;
    }
    
    public final void setPlacesNearby(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getPaths() {
        return null;
    }
    
    public final void setPaths(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId, long lastUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchAllPlaces(long lastUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, int maxDistance, long lastUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationPlaceId, long lastUpdate) {
        return null;
    }
}