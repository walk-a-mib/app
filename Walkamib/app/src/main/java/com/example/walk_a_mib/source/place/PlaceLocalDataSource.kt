package com.example.walk_a_mib.source.place

import com.example.walk_a_mib.database.MapsRoomDatabase
import com.example.walk_a_mib.database.PlaceDao
import com.example.walk_a_mib.logic_layer.domain.Node

class PlaceLocalDataSource(val mapsRoomDatabase: MapsRoomDatabase) : BasePlaceLocalDataSource() {
    val placeDao: PlaceDao = mapsRoomDatabase.placeDao()

    override fun getPlace(id: String) {
            MapsRoomDatabase.databaseWriteExecutor.execute {
                placeCallback?.onSuccessFromLocal(
                    id, placeDao.getPlace(id)
                )

            }
    }

    override fun getAllPlaces() {
        MapsRoomDatabase.databaseWriteExecutor.execute {
                var r = placeDao.getAllPlaces()
                allPlacesCallback?.onSuccessFromLocal(
                    placeDao.getAllPlaces()
                )
        }
    }

    override fun insertPlace(place: Node) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            placeDao?.insert(place!!)
            placeCallback?.onSuccessFromLocal(place.id, place)
        }

    }

    override fun insertPlaces(places: List<Node>) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            placeDao?.insert(places!!)
            allPlacesCallback?.onSuccessFromLocal(places)
        }
    }

}