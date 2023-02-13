package com.example.demoapiarch.domain;

import java.lang.System;

@androidx.room.Entity()
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0006H\u00d6\u0001J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0000J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00002\u0006\u0010\'\u001a\u00020\u0000J\b\u0010*\u001a\u00020\u0003H\u0016J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0006H\u00d6\u0001J\f\u00100\u001a\u00020&*\u00020&H\u0002R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00061"}, d2 = {"Lcom/example/demoapiarch/domain/Node;", "Landroid/os/Parcelable;", "id", "", "label", "type", "", "name", "description", "position", "Lcom/example/demoapiarch/domain/Coordinate;", "ga", "Lcom/example/demoapiarch/domain/GA;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/example/demoapiarch/domain/Coordinate;Lcom/example/demoapiarch/domain/GA;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getGa", "()Lcom/example/demoapiarch/domain/GA;", "setGa", "(Lcom/example/demoapiarch/domain/GA;)V", "getId", "setId", "getLabel", "setLabel", "getName", "setName", "getPosition", "()Lcom/example/demoapiarch/domain/Coordinate;", "setPosition", "(Lcom/example/demoapiarch/domain/Coordinate;)V", "getType", "()I", "setType", "(I)V", "describeContents", "getHeading", "", "destination", "getPathDirection", "origin", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "toRadian", "app_debug"})
public final class Node implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey(autoGenerate = false)
    @androidx.room.ColumnInfo(name = "node_id")
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "node_label")
    private java.lang.String label;
    @androidx.room.ColumnInfo(name = "node_type")
    private int type;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded(prefix = "node")
    private com.example.demoapiarch.domain.Coordinate position;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded(prefix = "node")
    private com.example.demoapiarch.domain.GA ga;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.domain.Node> CREATOR = null;
    
    public Node(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int type, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Coordinate position, @org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Coordinate getPosition() {
        return null;
    }
    
    public final void setPosition(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Coordinate p0) {
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
    
    private final double toRadian(double $this$toRadian) {
        return 0.0;
    }
    
    public final int getPathDirection(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node origin, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node destination) {
        return 0;
    }
    
    public final double getHeading(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node destination) {
        return 0.0;
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.domain.Node> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Node createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Node[] newArray(int size) {
            return null;
        }
    }
}