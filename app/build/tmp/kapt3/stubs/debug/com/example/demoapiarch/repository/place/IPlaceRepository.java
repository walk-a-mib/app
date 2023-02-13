package com.example.demoapiarch.repository.place;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/example/demoapiarch/repository/place/IPlaceRepository;", "", "fetchAllPlaces", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "fetchPlace", "placeId", "", "lastUpdate", "", "app_debug"})
public abstract interface IPlaceRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlace(@org.jetbrains.annotations.NotNull()
    java.lang.String placeId, long lastUpdate);
    
    @org.jetbrains.annotations.Nullable()
    public abstract androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchAllPlaces();
}