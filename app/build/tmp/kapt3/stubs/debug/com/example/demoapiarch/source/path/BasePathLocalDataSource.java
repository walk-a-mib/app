package com.example.demoapiarch.source.path;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/demoapiarch/source/path/BasePathLocalDataSource;", "", "()V", "pathCallback", "Lcom/example/demoapiarch/source/callbacks/PathCallback;", "getPathCallback", "()Lcom/example/demoapiarch/source/callbacks/PathCallback;", "setPathCallback", "(Lcom/example/demoapiarch/source/callbacks/PathCallback;)V", "getPath", "", "referenceId", "", "destinationId", "insertPath", "referencePlace", "Lcom/example/demoapiarch/domain/Node;", "steps", "", "Lcom/example/demoapiarch/model/path/Step;", "app_debug"})
public abstract class BasePathLocalDataSource {
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapiarch.source.callbacks.PathCallback pathCallback;
    
    public BasePathLocalDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.demoapiarch.source.callbacks.PathCallback getPathCallback() {
        return null;
    }
    
    public final void setPathCallback(@org.jetbrains.annotations.Nullable()
    com.example.demoapiarch.source.callbacks.PathCallback p0) {
    }
    
    public abstract void getPath(@org.jetbrains.annotations.NotNull()
    java.lang.String referenceId, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId);
    
    public abstract void insertPath(@org.jetbrains.annotations.NotNull()
    com.example.demoapiarch.domain.Node referencePlace, @org.jetbrains.annotations.NotNull()
    java.lang.String destinationId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.demoapiarch.model.path.Step> steps);
}