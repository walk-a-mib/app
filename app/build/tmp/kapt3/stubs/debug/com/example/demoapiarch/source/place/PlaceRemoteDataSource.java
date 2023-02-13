package com.example.demoapiarch.source.place;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/demoapiarch/source/place/PlaceRemoteDataSource;", "Lcom/example/demoapiarch/source/place/BasePlaceRemoteDataSource;", "apiKey", "", "(Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "placeApiService", "Lcom/example/demoapiarch/service/MapsApiService;", "getAllPlaces", "", "getPlace", "placeId", "app_debug"})
public final class PlaceRemoteDataSource extends com.example.demoapiarch.source.place.BasePlaceRemoteDataSource {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = null;
    private final com.example.demoapiarch.service.MapsApiService placeApiService = null;
    
    public PlaceRemoteDataSource(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @java.lang.Override()
    public void getPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId) {
    }
    
    @java.lang.Override()
    public void getAllPlaces() {
    }
}