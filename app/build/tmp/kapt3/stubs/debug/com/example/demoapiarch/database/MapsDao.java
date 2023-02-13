package com.example.demoapiarch.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\'J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\'J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/demoapiarch/database/MapsDao;", "T", "", "delete", "", "entity", "(Ljava/lang/Object;)V", "entities", "", "insert", "update", "app_debug"})
public abstract interface MapsDao<T extends java.lang.Object> {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(T entity);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities);
    
    @androidx.room.Update()
    public abstract void update(T entity);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities);
    
    @androidx.room.Delete()
    public abstract void delete(T entity);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities);
}