package com.example.demoapiarch.repository.path;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/demoapiarch/repository/path/IPathRepository;", "", "findPath", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "referencePlaceId", "", "destinationPlaceId", "lastUpdate", "", "app_debug"})
public abstract interface IPathRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> findPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationPlaceId, long lastUpdate);
}