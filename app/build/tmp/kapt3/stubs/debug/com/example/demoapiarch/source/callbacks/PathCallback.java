package com.example.demoapiarch.source.callbacks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH&J\u001e\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/example/demoapiarch/source/callbacks/PathCallback;", "Lcom/example/demoapiarch/source/MapsCallback;", "onSuccessFromLocal", "", "referenceId", "", "destinationId", "distance", "", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "steps", "", "Lcom/example/demoapiarch/model/path/Step;", "onSuccessFromRemote", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/path/PathBodyResponse;", "lastUpdate", "", "app_debug"})
public abstract interface PathCallback extends com.example.demoapiarch.source.MapsCallback {
    
    public abstract void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId, int distance, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.model.path.Step> steps);
    
    public abstract void onSuccessFromRemote(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.path.PathBodyResponse> apiResponse, long lastUpdate);
}