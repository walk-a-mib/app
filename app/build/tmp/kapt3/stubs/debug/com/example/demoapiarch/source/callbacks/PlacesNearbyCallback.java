package com.example.demoapiarch.source.callbacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J&\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/example/demoapiarch/source/callbacks/PlacesNearbyCallback;", "Lcom/example/demoapiarch/source/MapsCallback;", "onSuccessFromLocal", "", "referenceId", "", "maxDistance", "", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "neighbours", "", "Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "onSuccessFromRemote", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "lastUpdate", "", "app_debug"})
public abstract interface PlacesNearbyCallback extends com.example.demoapiarch.source.MapsCallback {
    
    public abstract void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, int maxDistance, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> neighbours);
    
    public abstract void onSuccessFromRemote(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse> apiResponse, int maxDistance, long lastUpdate);
}