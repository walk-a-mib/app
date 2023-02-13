package com.example.demoapiarch.source.callbacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/demoapiarch/source/callbacks/PlaceCallback;", "Lcom/example/demoapiarch/source/MapsCallback;", "onSuccessFromLocal", "", "reqId", "", "place", "Lcom/example/demoapiarch/domain/Node;", "onSuccessFromRemotePlace", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/place/PlaceBodyResponse;", "lastUpdate", "", "app_debug"})
public abstract interface PlaceCallback extends com.example.demoapiarch.source.MapsCallback {
    
    public abstract void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String reqId, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node place);
    
    public abstract void onSuccessFromRemotePlace(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.place.PlaceBodyResponse> apiResponse, long lastUpdate);
}