package com.example.walk_a_mib.source

import android.util.Log
import com.example.walk_a_mib.database.PlaceDao
import com.example.walk_a_mib.database.PlaceRoomDatabase
import com.example.walk_a_mib.logic_layer.domain.Node

class PlaceLocalDataSource(val placeRoomDatabase: PlaceRoomDatabase) : BasePlaceLocalDataSource() {
    val placeDao: PlaceDao = placeRoomDatabase.placeDao()

    override fun getPlace(id: String) {

        PlaceRoomDatabase.databaseWriteExecutor.execute {
            placeCallback?.onSuccessFromLocal(
                id, placeDao.getPlace(id)
            )

        }
    }

    override fun insertPlace(place: Node) {
        PlaceRoomDatabase.databaseWriteExecutor.execute {
                var allPlaces = placeDao?.getAll()
                val newPlaceKey = place.id
                if (allPlaces?.any{ it.id == newPlaceKey } == false)
                    placeDao?.insertPlace(place)

                placeCallback?.onSuccessFromLocal(place.id, place)
        }

    }

}