package com.example.walk_a_mib.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.database.PlaceDao
import java.util.concurrent.Executors


@Database(entities = [Node::class], version = 1)
abstract class PlaceRoomDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao

    private var INSTANCE: PlaceRoomDatabase? = null

    companion object {
        private val NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors()
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        private var INSTANCE: PlaceRoomDatabase? = null
        fun getDatabase(application: Application): PlaceRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(application.applicationContext, PlaceRoomDatabase::class.java, "MapsDB")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}