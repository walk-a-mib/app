package com.example.demoapiarch.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J2\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demoapiarch/service/MapsApiService;", "", "getAllPlaces", "Lretrofit2/Call;", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;", "apiKey", "", "getPath", "Lcom/example/demoapiarch/model/path/PathBodyResponse;", "reqBody", "Lcom/example/demoapiarch/model/path/PathBodyRequest;", "getPlace", "Lcom/example/demoapiarch/model/place/PlaceBodyResponse;", "placeId", "getPlacesNearby", "Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "maxDistance", "", "app_debug"})
public abstract interface MapsApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "allPlaces")
    public abstract retrofit2.Call<com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.AllPlacesBodyResponse>> getAllPlaces(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "place")
    public abstract retrofit2.Call<com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.PlaceBodyResponse>> getPlace(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "place_id")
    java.lang.String placeId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "findPlacesNearby")
    public abstract retrofit2.Call<com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse>> getPlacesNearby(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "reference_place_id")
    java.lang.String placeId, @retrofit2.http.Query(value = "max_distance")
    int maxDistance, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "findPath")
    public abstract retrofit2.Call<com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.path.PathBodyResponse>> getPath(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.demoapiarch.model.path.PathBodyRequest reqBody, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String apiKey);
}