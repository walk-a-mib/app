package com.example.demoapiarch.model.path;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/example/demoapiarch/model/path/PathBodyResponse;", "Landroid/os/Parcelable;", "distance", "", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "steps", "", "Lcom/example/demoapiarch/model/path/Step;", "(ILcom/example/demoapiarch/domain/Node;Ljava/util/List;)V", "getDistance", "()I", "getReferencePlace", "()Lcom/example/demoapiarch/domain/Node;", "getSteps", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class PathBodyResponse implements android.os.Parcelable {
    private final int distance = 0;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reference_place")
    private final com.example.demoapiarch.domain.Node referencePlace = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.demoapiarch.model.path.Step> steps = null;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.model.path.PathBodyResponse> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.model.path.PathBodyResponse copy(int distance, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.path.Step> steps) {
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
    
    public PathBodyResponse(int distance, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.path.Step> steps) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getDistance() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.domain.Node getReferencePlace() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.demoapiarch.model.path.Step> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.demoapiarch.model.path.Step> getSteps() {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.model.path.PathBodyResponse> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.path.PathBodyResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.model.path.PathBodyResponse[] newArray(int size) {
            return null;
        }
    }
}