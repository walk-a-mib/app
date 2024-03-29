package com.example.walk_a_mib.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.walk_a_mib.database.relationship.Pathway
import com.example.walk_a_mib.database.relationship.Proximity
import com.example.walk_a_mib.logic_layer.domain.Edge
import com.example.walk_a_mib.logic_layer.domain.Node
import java.util.concurrent.Executors

@Database(entities = [Proximity::class, Node::class, Pathway::class, Edge::class], version = 1)
abstract class MapsRoomDatabase: RoomDatabase() {

    abstract fun nodeDao(): NodeDao
    abstract fun placeNearbyDao(): PlaceNearbyDao
    abstract fun pathDao(): PathDao
    abstract fun edgeDao(): EdgeDao

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