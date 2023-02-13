package com.example.demoapiarch.repository.place;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010\"\u001a\u00020\nH\u0002J\u0014\u0010&\u001a\u00020 2\n\u0010\'\u001a\u00060(j\u0002`)H\u0016J\u0014\u0010*\u001a\u00020 2\n\u0010\'\u001a\u00060(j\u0002`)H\u0016J\u001a\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010+\u001a\u00020 2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010/H\u0016J\u001e\u00100\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u00104\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u000205022\u0006\u0010#\u001a\u00020$H\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00066"}, d2 = {"Lcom/example/demoapiarch/repository/place/PlaceRepository;", "Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "Lcom/example/demoapiarch/source/callbacks/PlaceCallback;", "Lcom/example/demoapiarch/source/callbacks/AllPlacesCallback;", "placeRemoteDataSource", "Lcom/example/demoapiarch/source/place/BasePlaceRemoteDataSource;", "placeLocalDataSource", "Lcom/example/demoapiarch/source/place/BasePlaceLocalDataSource;", "(Lcom/example/demoapiarch/source/place/BasePlaceRemoteDataSource;Lcom/example/demoapiarch/source/place/BasePlaceLocalDataSource;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allPlaces", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "getAllPlaces", "()Landroidx/lifecycle/MutableLiveData;", "choice", "", "getChoice", "()Z", "setChoice", "(Z)V", "place", "getPlace", "getPlaceLocalDataSource", "()Lcom/example/demoapiarch/source/place/BasePlaceLocalDataSource;", "getPlaceRemoteDataSource", "()Lcom/example/demoapiarch/source/place/BasePlaceRemoteDataSource;", "fetchAllPlaces", "fetchAllPlacesFromRemote", "", "fetchPlace", "placeId", "lastUpdate", "", "fetchPlaceFromRemote", "onFailureFromLocal", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailureFromRemote", "onSuccessFromLocal", "reqId", "Lcom/example/demoapiarch/domain/Node;", "places", "", "onSuccessFromRemoteAllPlaces", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;", "onSuccessFromRemotePlace", "Lcom/example/demoapiarch/model/place/PlaceBodyResponse;", "app_debug"})
public final class PlaceRepository implements com.example.demoapiarch.repository.place.IPlaceRepository, com.example.demoapiarch.source.callbacks.PlaceCallback, com.example.demoapiarch.source.callbacks.AllPlacesCallback {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.place.BasePlaceRemoteDataSource placeRemoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.place.BasePlaceLocalDataSource placeLocalDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> place = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> allPlaces = null;
    private boolean choice = true;
    
    public PlaceRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.place.BasePlaceRemoteDataSource placeRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.place.BasePlaceLocalDataSource placeLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.place.BasePlaceRemoteDataSource getPlaceRemoteDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.place.BasePlaceLocalDataSource getPlaceLocalDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getPlace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getAllPlaces() {
        return null;
    }
    
    public final boolean getChoice() {
        return false;
    }
    
    public final void setChoice(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId, long lastUpdate) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchAllPlaces() {
        return null;
    }
    
    private final void fetchAllPlacesFromRemote() {
    }
    
    private final void fetchPlaceFromRemote(java.lang.String placeId) {
    }
    
    @java.lang.Override()
    public void onSuccessFromRemotePlace(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.PlaceBodyResponse> apiResponse, long lastUpdate) {
    }
    
    @java.lang.Override()
    public void onSuccessFromLocal(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.domain.Node> places) {
    }
    
    @java.lang.Override()
    public void onSuccessFromRemoteAllPlaces(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.AllPlacesBodyResponse> apiResponse, long lastUpdate) {
    }
    
    @java.lang.Override()
    public void onFailureFromRemote(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
    
    @java.lang.Override()
    public void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String reqId, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node place) {
    }
    
    @java.lang.Override()
    public void onFailureFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
}