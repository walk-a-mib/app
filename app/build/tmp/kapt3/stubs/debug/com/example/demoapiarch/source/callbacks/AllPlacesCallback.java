package com.example.demoapiarch.source.callbacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u001e\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/example/demoapiarch/source/callbacks/AllPlacesCallback;", "Lcom/example/demoapiarch/source/MapsCallback;", "onSuccessFromLocal", "", "places", "", "Lcom/example/demoapiarch/domain/Node;", "onSuccessFromRemoteAllPlaces", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;", "lastUpdate", "", "app_debug"})
public abstract interface AllPlacesCallback extends com.example.demoapiarch.source.MapsCallback {
    
    public abstract void onSuccessFromLocal(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.domain.Node> places);
    
    public abstract void onSuccessFromRemoteAllPlaces(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.AllPlacesBodyResponse> apiResponse, long lastUpdate);
}