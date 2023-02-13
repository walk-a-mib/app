package com.example.demoapiarch.domain;

import java.lang.System;

@androidx.room.Entity()
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006\""}, d2 = {"Lcom/example/demoapiarch/domain/Edge;", "Landroid/os/Parcelable;", "id", "", "label", "type", "", "distance", "ga", "Lcom/example/demoapiarch/domain/GA;", "(Ljava/lang/String;Ljava/lang/String;IILcom/example/demoapiarch/domain/GA;)V", "getDistance", "()I", "setDistance", "(I)V", "getGa", "()Lcom/example/demoapiarch/domain/GA;", "setGa", "(Lcom/example/demoapiarch/domain/GA;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLabel", "setLabel", "getType", "setType", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Edge implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey(autoGenerate = false)
    @androidx.room.ColumnInfo(name = "edge_id")
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "edge_label")
    private java.lang.String label;
    @androidx.room.ColumnInfo(name = "edge_type")
    private int type;
    private int distance;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded(prefix = "edge")
    private com.example.demoapiarch.domain.GA ga;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.domain.Edge> CREATOR = null;
    
    public Edge(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int type, int distance, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.GA ga) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final void setLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int p0) {
    }
    
    public final int getDistance() {
        return 0;
    }
    
    public final void setDistance(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.GA getGa() {
        return null;
    }
    
    public final void setGa(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.GA p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.domain.Edge> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Edge createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Edge[] newArray(int size) {
            return null;
        }
    }
}