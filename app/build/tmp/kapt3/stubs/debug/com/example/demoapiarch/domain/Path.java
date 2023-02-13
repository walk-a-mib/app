package com.example.demoapiarch.domain;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003J\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0005j\b\u0012\u0004\u0012\u00020\u0015`\u0007J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0003J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003H\u00d6\u0001R.\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/example/demoapiarch/domain/Path;", "Landroid/os/Parcelable;", "pathLength", "", "nodeList", "Ljava/util/ArrayList;", "Lcom/example/demoapiarch/domain/Node;", "Lkotlin/collections/ArrayList;", "edgeList", "Lcom/example/demoapiarch/domain/Edge;", "(ILjava/util/ArrayList;Ljava/util/ArrayList;)V", "getEdgeList", "()Ljava/util/ArrayList;", "setEdgeList", "(Ljava/util/ArrayList;)V", "getNodeList", "setNodeList", "getPathLength", "()I", "describeContents", "getPreposition", "", "art", "from", "", "getStepTextIndications", "start", "way", "end", "heading", "getTextIndications", "getTurnTextIndications", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Path implements android.os.Parcelable {
    private final int pathLength = 0;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private java.util.ArrayList<com.example.demoapiarch.domain.Node> nodeList;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private java.util.ArrayList<com.example.demoapiarch.domain.Edge> edgeList;
    public static final android.os.Parcelable.Creator<com.example.demoapiarch.domain.Path> CREATOR = null;
    
    public Path(int pathLength, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.demoapiarch.domain.Node> nodeList, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.demoapiarch.domain.Edge> edgeList) {
        super();
    }
    
    public final int getPathLength() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.demoapiarch.domain.Node> getNodeList() {
        return null;
    }
    
    public final void setNodeList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.demoapiarch.domain.Node> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.demoapiarch.domain.Edge> getEdgeList() {
        return null;
    }
    
    public final void setEdgeList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.demoapiarch.domain.Edge> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getTextIndications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStepTextIndications(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node start, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Edge way, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node end, int heading) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTurnTextIndications(int heading) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPreposition(@org.jetbrains.annotations.NotNull()
    java.lang.String art, boolean from) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.example.demoapiarch.domain.Path> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Path createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.example.demoapiarch.domain.Path[] newArray(int size) {
            return null;
        }
    }
}