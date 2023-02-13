package com.example.demoapiarch.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/demoapiarch/domain/EdgeType;", "Lcom/example/demoapiarch/domain/Type;", "()V", "table", "", "", "[[Ljava/lang/String;", "getTypeInt", "", "type", "getTypeName", "id", "getTypePreposition", "getTypeString", "getTypeVerb", "up", "", "app_debug"})
public final class EdgeType implements com.example.demoapiarch.domain.Type {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapiarch.domain.EdgeType INSTANCE = null;
    private static java.lang.String[][] table = {{"elevator_step", "l\' ", "ascensore", "prendi", "prendi"}, {"stairs_step", "le ", "scale", "sali", "scendi"}, {"stairs_automated_step", "le ", "scale", "sali", "scendi"}, {"corridor", "il ", "corridoio", "percorri", "percorri"}, {"path", "", "", "vai", "vai"}};
    
    private EdgeType() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeString(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeName(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypePreposition(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTypeVerb(int id, boolean up) {
        return null;
    }
    
    public final int getTypeInt(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return 0;
    }
}