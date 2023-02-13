package com.example.demoapiarch.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.demoapiarch.database.relationship.Proximity.class, com.example.demoapiarch.domain.Node.class, com.example.demoapiarch.database.relationship.Pathway.class, com.example.demoapiarch.domain.Edge.class}, version = 1)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/example/demoapiarch/database/MapsRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "edgeDao", "Lcom/example/demoapiarch/database/EdgeDao;", "pathDao", "Lcom/example/demoapiarch/database/PathDao;", "placeDao", "Lcom/example/demoapiarch/database/PlaceDao;", "placeNearbyDao", "Lcom/example/demoapiarch/database/PlaceNearbyDao;", "Companion", "app_debug"})
public abstract class MapsRoomDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.demoapiarch.database.MapsRoomDatabase.Companion Companion = null;
    private static final int NUMBER_OF_THREADS = 0;
    private static final java.util.concurrent.ExecutorService databaseWriteExecutor = null;
    @kotlin.jvm.Volatile()
    private static volatile com.example.demoapiarch.database.MapsRoomDatabase INSTANCE;
    
    public MapsRoomDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demoapiarch.database.PlaceDao placeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demoapiarch.database.PlaceNearbyDao placeNearbyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demoapiarch.database.PathDao pathDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.demoapiarch.database.EdgeDao edgeDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/demoapiarch/database/MapsRoomDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/demoapiarch/database/MapsRoomDatabase;", "NUMBER_OF_THREADS", "", "databaseWriteExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getDatabaseWriteExecutor", "()Ljava/util/concurrent/ExecutorService;", "getDatabase", "application", "Landroid/app/Application;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final java.util.concurrent.ExecutorService getDatabaseWriteExecutor() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.demoapiarch.database.MapsRoomDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
    }
}