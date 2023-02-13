package com.example.demoapiarch.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&J\u0014\u0010\u0007\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/demoapiarch/source/MapsCallback;", "", "onFailureFromLocal", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailureFromRemote", "app_debug"})
public abstract interface MapsCallback {
    
    public abstract void onFailureFromRemote(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception);
    
    public abstract void onFailureFromLocal(@org.jetbrains.annotations.NotNull()
    java.lang.Exception exception);
}