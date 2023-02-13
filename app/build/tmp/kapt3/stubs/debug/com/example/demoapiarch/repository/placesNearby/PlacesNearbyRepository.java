package com.example.demoapiarch.repository.placesNearby;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010#\u001a\u00020\u001c2\n\u0010$\u001a\u00060%j\u0002`&H\u0016J\u0014\u0010\'\u001a\u00020\u001c2\n\u0010$\u001a\u00060%j\u0002`&H\u0016J2\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0016J&\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/example/demoapiarch/repository/placesNearby/PlacesNearbyRepository;", "Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "Lcom/example/demoapiarch/source/callbacks/PlacesNearbyCallback;", "placesNearbyRemoteDataSource", "Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyRemoteDataSource;", "placesNearbyLocalDataSource", "Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyLocalDataSource;", "(Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyRemoteDataSource;Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyLocalDataSource;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allPlacesNearby", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "getAllPlacesNearby", "()Landroidx/lifecycle/MutableLiveData;", "choice", "", "getChoice", "()Z", "setChoice", "(Z)V", "getPlacesNearbyLocalDataSource", "()Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyLocalDataSource;", "getPlacesNearbyRemoteDataSource", "()Lcom/example/demoapiarch/source/placesNearby/BasePlacesNearbyRemoteDataSource;", "fetchFromRemote", "", "referencePlaceId", "maxDistance", "", "fetchPlacesNearby", "lastUpdate", "", "onFailureFromLocal", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailureFromRemote", "onSuccessFromLocal", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "neighbours", "", "Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "onSuccessFromRemote", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "app_debug"})
public final class PlacesNearbyRepository implements com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository, com.example.demoapiarch.source.callbacks.PlacesNearbyCallback {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.placesNearby.BasePlacesNearbyRemoteDataSource placesNearbyRemoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.placesNearby.BasePlacesNearbyLocalDataSource placesNearbyLocalDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> allPlacesNearby = null;
    private boolean choice = true;
    
    public PlacesNearbyRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.placesNearby.BasePlacesNearbyRemoteDataSource placesNearbyRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.placesNearby.BasePlacesNearbyLocalDataSource placesNearbyLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.placesNearby.BasePlacesNearbyRemoteDataSource getPlacesNearbyRemoteDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.placesNearby.BasePlacesNearbyLocalDataSource getPlacesNearbyLocalDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getAllPlacesNearby() {
        return null;
    }
    
    public final boolean getChoice() {
        return false;
    }
    
    public final void setChoice(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, int maxDistance, long lastUpdate) {
        return null;
    }
    
    private final void fetchFromRemote(java.lang.String referencePlaceId, int maxDistance) {
    }
    
    @java.lang.Override()
    public void onSuccessFromRemote(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse> apiResponse, int maxDistance, long lastUpdate) {
    }
    
    @java.lang.Override()
    public void onFailureFromRemote(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
    
    @java.lang.Override()
    public void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, int maxDistance, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> neighbours) {
    }
    
    @java.lang.Override()
    public void onFailureFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
}