package com.example.demoapiarch.source.placesNearby

import android.util.Log
import com.example.demoapiarch.database.*
import com.example.demoapiarch.database.relationship.Proximity
import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.placesNearby.Neighbour

class PlacesNearbyLocalDataSource(val mapsRoomDatabase: MapsRoomDatabase) : BasePlacesNearbyLocalDataSource() {
    val placeNearbyDao: PlaceNearbyDao = mapsRoomDatabase.placeNearbyDao()
    val placeDao : PlaceDao = mapsRoomDatabase.placeDao()

    override fun getPlacesNearby(referenceId: String, maxDistance: Int) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
                placeNearbyCallback?.onSuccessFromLocal(
                    referenceId, maxDistance,
                    placeDao.getPlace(referenceId),
                    placeNearbyDao.getPlacesNearby(referenceId, maxDistance)
                )

        }
    }

    override fun insertPlacesNearby(referencePlace: Node, maxDistance: Int, neighbours: List<Neighbour>) {
        var proximities = mutableListOf<Proximity>()
        var places = mutableListOf(referencePlace)
        for (neighbour in neighbours) {
            proximities.add(Proximity(referencePlace.id, neighbour.place.id, neighbour.distance))
            places.add(neighbour.place)
        }

        MapsRoomDatabase.databaseWriteExecutor.execute {
            placeDao.insert(places)
            placeNearbyDao?.insert(proximities)
            placeNearbyCallback?.onSuccessFromLocal(referencePlace.id, maxDistance, referencePlace, neighbours) }


    }
}