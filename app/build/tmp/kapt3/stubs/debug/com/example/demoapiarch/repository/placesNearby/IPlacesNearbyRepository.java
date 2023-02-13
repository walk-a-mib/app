package com.example.demoapiarch.repository.placesNearby;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/demoapiarch/repository/placesNearby/IPlacesNearbyRepository;", "", "fetchPlacesNearby", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "referencePlaceId", "", "maxDistance", "", "lastUpdate", "", "app_debug"})
public abstract interface IPlacesNearbyRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> fetchPlacesNearby(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, int maxDistance, long lastUpdate);
}