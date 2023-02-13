package com.example.demoapiarch.model.placesNearby;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/example/demoapiarch/model/placesNearby/PlacesNearbyBodyResponse;", "Landroid/os/Parcelable;", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "placesNearby", "", "Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "(Lcom/example/demoapiarch/domain/Node;Ljava/util/List;)V", "getPlacesNearby", "()Ljava/util/List;", "getReferencePlace", "()Lcom/example/demoapiarch/domain/Node;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class PlacesNearbyBodyResponse implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.domain.Node referencePlace = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> placesNearby = null;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse copy(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> placesNearby) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PlacesNearbyBodyResponse(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> placesNearby) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node getReferencePlace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.demoapiarch.model.placesNearby.Neighbour> getPlacesNearby() {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse[] newArray(int size) {
            return null;
        }
    }
}