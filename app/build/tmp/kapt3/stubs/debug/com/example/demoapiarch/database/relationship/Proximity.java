package com.example.demoapiarch.database.relationship;

import java.lang.System;

@androidx.room.Entity(primaryKeys = {"reference_id", "neighbour_id"}, foreignKeys = {@androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Node.class, childColumns = {"reference_id"}, parentColumns = {"node_id"}), @androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Node.class, childColumns = {"neighbour_id"}, parentColumns = {"node_id"})})
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/example/demoapiarch/database/relationship/Proximity;", "Landroid/os/Parcelable;", "referenceId", "", "neighborId", "distance", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDistance", "()I", "setDistance", "(I)V", "getNeighborId", "()Ljava/lang/String;", "setNeighborId", "(Ljava/lang/String;)V", "getReferenceId", "setReferenceId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Proximity implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "reference_id")
    private java.lang.String referenceId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "neighbour_id")
    private java.lang.String neighborId;
    @androidx.room.ColumnInfo(name = "distance")
    private int distance;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.database.relationship.Proximity> CREATOR = null;
    
    public Proximity(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String neighborId, int distance) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReferenceId() {
        return null;
    }
    
    public final void setReferenceId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNeighborId() {
        return null;
    }
    
    public final void setNeighborId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getDistance() {
        return 0;
    }
    
    public final void setDistance(int p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.database.relationship.Proximity> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.database.relationship.Proximity createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.database.relationship.Proximity[] newArray(int size) {
            return null;
        }
    }
}