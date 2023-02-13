package com.example.demoapiarch.model.placesNearby;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/example/demoapiarch/model/placesNearby/Neighbour;", "Landroid/os/Parcelable;", "place", "Lcom/example/demoapiarch/domain/Node;", "distance", "", "(Lcom/example/demoapiarch/domain/Node;I)V", "getDistance", "()I", "getPlace", "()Lcom/example/demoapiarch/domain/Node;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Neighbour implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private final com.example.demoapiarch.domain.Node place = null;
    @androidx.room.ColumnInfo(name = "distance")
    private final int distance = 0;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.model.placesNearby.Neighbour> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.model.placesNearby.Neighbour copy(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node place, int distance) {
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
    
    public Neighbour(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node place, int distance) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node getPlace() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getDistance() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.model.placesNearby.Neighbour> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.placesNearby.Neighbour createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.placesNearby.Neighbour[] newArray(int size) {
            return null;
        }
    }
}