package com.example.demoapiarch.database.relationship;

import java.lang.System;

@androidx.room.Entity(foreignKeys = {@androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Node.class, childColumns = {"reference_id"}, parentColumns = {"node_id"}), @androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Node.class, childColumns = {"destination_id"}, parentColumns = {"node_id"}), @androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Node.class, childColumns = {"intermediate_id"}, parentColumns = {"node_id"}), @androidx.room.ForeignKey(entity = com.example.demoapiarch.domain.Edge.class, childColumns = {"connecting_edge_id"}, parentColumns = {"edge_id"})})
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\bH\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/example/demoapiarch/database/relationship/Pathway;", "Landroid/os/Parcelable;", "referenceId", "", "destinationId", "intermediateId", "edgeId", "orderNumber", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDestinationId", "()Ljava/lang/String;", "setDestinationId", "(Ljava/lang/String;)V", "getEdgeId", "setEdgeId", "id", "getId", "()I", "setId", "(I)V", "getIntermediateId", "setIntermediateId", "getOrderNumber", "setOrderNumber", "getReferenceId", "setReferenceId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Pathway implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "reference_id")
    private java.lang.String referenceId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "destination_id")
    private java.lang.String destinationId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "intermediate_id")
    private java.lang.String intermediateId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "connecting_edge_id")
    private java.lang.String edgeId;
    @androidx.room.ColumnInfo(name = "order_number")
    private int orderNumber;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.database.relationship.Pathway> CREATOR = null;
    
    public Pathway(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId, @org.jetbrains.annotations.NotNull()
    java.lang.String intermediateId, @org.jetbrains.annotations.NotNull()
    java.lang.String edgeId, int orderNumber) {
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
    public final java.lang.String getDestinationId() {
        return null;
    }
    
    public final void setDestinationId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIntermediateId() {
        return null;
    }
    
    public final void setIntermediateId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEdgeId() {
        return null;
    }
    
    public final void setEdgeId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getOrderNumber() {
        return 0;
    }
    
    public final void setOrderNumber(int p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.database.relationship.Pathway> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.database.relationship.Pathway createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.database.relationship.Pathway[] newArray(int size) {
            return null;
        }
    }
}