package com.example.demoapiarch.source

import android.util.Log
import com.example.demoapiarch.database.PlaceDao
import com.example.demoapiarch.database.PlaceRoomDatabase
import com.example.demoapiarch.domain.Node

class PlaceLocalDataSource(val placeRoomDatabase: PlaceRoomDatabase) : BasePlaceLocalDataSource() {
    val placeDao: PlaceDao = placeRoomDatabase.placeDao()

    override fun getPlace(id: String) {
        PlaceRoomDatabase.databaseWriteExecutor.execute {
            var place = placeDao.getPlace(id)
            if (place != null)
                placeCallback?.onSuccessFromLocal(
                    place!!
                )
            else
                Log.d("MAIN", "GOING REMOTE")
        }
    }

    override fun insertPlace(place: Node) {
        PlaceRoomDatabase.databaseWriteExecutor.execute {
                var allPlaces = placeDao?.getAll()
                val newPlaceKey = place.id
                if (allPlaces?.any{ it.id == newPlaceKey } == false)
                    placeDao?.insertPlace(place)

                placeCallback?.onSuccessFromLocal(place)
        }

    }

}