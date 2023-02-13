package com.example.demoapiarch.repository.path;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\'\u001a\u00020\tH\u0002J&\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\'\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020%2\n\u0010,\u001a\u00060-j\u0002`.H\u0016J\u0014\u0010/\u001a\u00020%2\n\u0010,\u001a\u00060-j\u0002`.H\u0016J:\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J\u001e\u00103\u001a\u00020%2\f\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u0010)\u001a\u00020*H\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00067"}, d2 = {"Lcom/example/demoapiarch/repository/path/PathRepository;", "Lcom/example/demoapiarch/repository/path/IPathRepository;", "Lcom/example/demoapiarch/source/callbacks/PathCallback;", "pathRemoteDataSource", "Lcom/example/demoapiarch/source/path/BasePathRemoteDataSource;", "pathLocalDataSource", "Lcom/example/demoapiarch/source/path/BasePathLocalDataSource;", "(Lcom/example/demoapiarch/source/path/BasePathRemoteDataSource;Lcom/example/demoapiarch/source/path/BasePathLocalDataSource;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allPaths", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/demoapiarch/model/CallResult;", "getAllPaths", "()Landroidx/lifecycle/MutableLiveData;", "choice", "", "getChoice", "()Z", "setChoice", "(Z)V", "getPathLocalDataSource", "()Lcom/example/demoapiarch/source/path/BasePathLocalDataSource;", "getPathRemoteDataSource", "()Lcom/example/demoapiarch/source/path/BasePathRemoteDataSource;", "buildPath", "Lcom/example/demoapiarch/domain/Path;", "distance", "", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "steps", "", "Lcom/example/demoapiarch/model/path/Step;", "fetchFromRemote", "", "referencePlaceId", "destinationPlaceId", "findPath", "lastUpdate", "", "onFailureFromLocal", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailureFromRemote", "onSuccessFromLocal", "referenceId", "destinationId", "onSuccessFromRemote", "apiResponse", "Lcom/example/demoapiarch/model/GenericApiResponse;", "Lcom/example/demoapiarch/model/path/PathBodyResponse;", "app_debug"})
public final class PathRepository implements com.example.demoapiarch.repository.path.IPathRepository, com.example.demoapiarch.source.callbacks.PathCallback {
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.path.BasePathRemoteDataSource pathRemoteDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.demoapiarch.source.path.BasePathLocalDataSource pathLocalDataSource = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> allPaths = null;
    private boolean choice = true;
    
    public PathRepository(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.path.BasePathRemoteDataSource pathRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.source.path.BasePathLocalDataSource pathLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.path.BasePathRemoteDataSource getPathRemoteDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.demoapiarch.source.path.BasePathLocalDataSource getPathLocalDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> getAllPaths() {
        return null;
    }
    
    public final boolean getChoice() {
        return false;
    }
    
    public final void setChoice(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.MutableLiveData<com.example.demoapiarch.model.CallResult> findPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referencePlaceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationPlaceId, long lastUpdate) {
        return null;
    }
    
    private final void fetchFromRemote(java.lang.String referencePlaceId, java.lang.String destinationPlaceId) {
    }
    
    @java.lang.Override()
    public void onSuccessFromRemote(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.model.GenericApiResponse<com.example.demoapiarch.model.path.PathBodyResponse> apiResponse, long lastUpdate) {
    }
    
    @java.lang.Override()
    public void onFailureFromRemote(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
    
    @java.lang.Override()
    public void onSuccessFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId, int distance, @org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.demoapiarch.model.path.Step> steps) {
    }
    
    @java.lang.Override()
    public void onFailureFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception) {
    }
    
    private final com.example.demoapiarch.domain.Path buildPath(int distance, com.example.demoapiarch.domain.Node referencePlace, java.util.List<com.example.demoapiarch.model.path.Step> steps) {
        return null;
    }
}