package com.example.demoapiarch.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoapiarch.database.relationship.Proximity
import com.example.demoapiarch.domain.Node
import java.util.concurrent.Executors

@Database(entities = [Proximity::class, Node::class], version = 1)
abstract class MapsRoomDatabase: RoomDatabase() {

    abstract fun placeDao(): PlaceDao
    abstract fun placeNearbyDao(): PlaceNearbyDao

    companion object {
        private val NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors()
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        @Volatile
        private var INSTANCE: MapsRoomDatabase? = null

        fun getDatabase(application: Application): MapsRoomDatabase {
            return (INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(application, MapsRoomDatabase::class.java, "MapsDB")
                    .build().also { INSTANCE = it }
            })
        }
    }
}