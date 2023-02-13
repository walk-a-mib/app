package com.example.demoapiarch.source.path;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/demoapiarch/source/path/BasePathRemoteDataSource;", "", "()V", "pathCallback", "Lcom/example/demoapiarch/source/callbacks/PathCallback;", "getPathCallback", "()Lcom/example/demoapiarch/source/callbacks/PathCallback;", "setPathCallback", "(Lcom/example/demoapiarch/source/callbacks/PathCallback;)V", "getPath", "", "referenceId", "", "destinationId", "app_debug"})
public abstract class BasePathRemoteDataSource {
    @org.jetbrains.annotations.Nullable()
    private com.example.demoapiarch.source.callbacks.PathCallback pathCallback;
    
    public BasePathRemoteDataSource() {
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
}