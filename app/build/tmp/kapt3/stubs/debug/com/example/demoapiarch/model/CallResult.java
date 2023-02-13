package com.example.demoapiarch.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/example/demoapiarch/model/CallResult;", "", "()V", "isSuccess", "", "toString", "", "Error", "SuccessAllPlaces", "SuccessPath", "SuccessPlace", "SuccessPlacesNearby", "app_debug"})
public class CallResult {
    
    public CallResult() {
        super();
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demoapiarch/model/CallResult$SuccessPlace;", "Lcom/example/demoapiarch/model/CallResult;", "placeResponse", "Lcom/example/demoapiarch/model/place/PlaceBodyResponse;", "(Lcom/example/demoapiarch/model/place/PlaceBodyResponse;)V", "getPlaceResponse", "()Lcom/example/demoapiarch/model/place/PlaceBodyResponse;", "app_debug"})
    public static final class SuccessPlace extends com.example.demoapiarch.model.CallResult {
        @org.jetbrains.annotations.NotNull()
        private final com.example.demoapiarch.model.place.PlaceBodyResponse placeResponse = null;
        
        public SuccessPlace(@org.jetbrains.annotations.NotNull()
        com.example.demoapiarch.model.place.PlaceBodyResponse placeResponse) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.demoapiarch.model.place.PlaceBodyResponse getPlaceResponse() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demoapiarch/model/CallResult$SuccessPlacesNearby;", "Lcom/example/demoapiarch/model/CallResult;", "placesNearbyResponse", "Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "(Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;)V", "getPlacesNearbyResponse", "()Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "app_debug"})
    public static final class SuccessPlacesNearby extends com.example.demoapiarch.model.CallResult {
        @org.jetbrains.annotations.NotNull()
        private final com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse placesNearbyResponse = null;
        
        public SuccessPlacesNearby(@org.jetbrains.annotations.NotNull()
        com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse placesNearbyResponse) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse getPlacesNearbyResponse() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demoapiarch/model/CallResult$SuccessPath;", "Lcom/example/demoapiarch/model/CallResult;", "pathResponse", "Lcom/example/demoapiarch/domain/Path;", "(Lcom/example/demoapiarch/domain/Path;)V", "getPathResponse", "()Lcom/example/demoapiarch/domain/Path;", "app_debug"})
    public static final class SuccessPath extends com.example.demoapiarch.model.CallResult {
        @org.jetbrains.annotations.NotNull()
        private final com.example.demoapiarch.domain.Path pathResponse = null;
        
        public SuccessPath(@org.jetbrains.annotations.NotNull()
        com.example.demoapiarch.domain.Path pathResponse) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.demoapiarch.domain.Path getPathResponse() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demoapiarch/model/CallResult$SuccessAllPlaces;", "Lcom/example/demoapiarch/model/CallResult;", "allPlaces", "Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;", "(Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;)V", "getAllPlaces", "()Lcom/example/demoapiarch/model/place/AllPlacesBodyResponse;", "app_debug"})
    public static final class SuccessAllPlaces extends com.example.demoapiarch.model.CallResult {
        @org.jetbrains.annotations.NotNull()
        private final com.example.demoapiarch.model.place.AllPlacesBodyResponse allPlaces = null;
        
        public SuccessAllPlaces(@org.jetbrains.annotations.NotNull()
        com.example.demoapiarch.model.place.AllPlacesBodyResponse allPlaces) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.demoapiarch.model.place.AllPlacesBodyResponse getAllPlaces() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/demoapiarch/model/CallResult$Error;", "Lcom/example/demoapiarch/model/CallResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Error extends com.example.demoapiarch.model.CallResult {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.Nullable()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMessage() {
            return null;
        }
    }
}