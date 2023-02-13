package com.example.demoapiarch.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/example/demoapiarch/util/Constants;", "", "()V", "API_BASE_URL", "", "getAPI_BASE_URL", "()Ljava/lang/String;", "FRESH_TIMEOUT", "", "getFRESH_TIMEOUT", "()I", "RETROFIT_ERROR", "getRETROFIT_ERROR", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapiarch.util.Constants INSTANCE = null;
    private static final int FRESH_TIMEOUT = 3600000;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String RETROFIT_ERROR = "retrofit_error";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_BASE_URL = "https://walkamib.azurewebsites.net/api/";
    
    private Constants() {
        super();
    }
    
    public final int getFRESH_TIMEOUT() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRETROFIT_ERROR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAPI_BASE_URL() {
        return null;
    }
}