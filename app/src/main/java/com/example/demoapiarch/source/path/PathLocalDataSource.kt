package com.example.demoapiarch.source.path

import android.util.Log
import com.example.demoapiarch.database.EdgeDao
import com.example.demoapiarch.database.MapsRoomDatabase
import com.example.demoapiarch.database.PathDao
import com.example.demoapiarch.database.PlaceDao
import com.example.demoapiarch.database.relationship.Pathway
import com.example.demoapiarch.domain.Edge
import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.model.path.Step

class PathLocalDataSource(val mapsRoomDatabase: MapsRoomDatabase) : BasePathLocalDataSource() {
    val pathDao: PathDao = mapsRoomDatabase.pathDao()
    val placeDao : PlaceDao = mapsRoomDatabase.placeDao()
    val edgeDao : EdgeDao = mapsRoomDatabase.edgeDao()

    override fun getPath(referenceId: String, destinationId: String) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            var res : List<Step> = pathDao.getPath(referenceId, destinationId)!!
            pathCallback?.onSuccessFromLocal(
                referenceId,
                destinationId,
                getPathLength(res),
                placeDao.getPlace(referenceId),
                pathDao.getPath(referenceId, destinationId)
            )
        }
    }

    override fun insertPath(referencePlace: Node, destinationId: String, steps: List<Step>) {
        var pathways = mutableListOf<Pathway>()
        var places = mutableListOf(referencePlace)
        var edges = mutableListOf<Edge>()
        var orderNumber = 1
        for (step in steps) {
            pathways.add(Pathway(referencePlace.id, destinationId, step.node.id, step.edge.id, orderNumber++))
            places.add(step.node)
            edges.add(step.edge)
        }

        MapsRoomDatabase.databaseWriteExecutor.execute {
                placeDao.insert(places)
                edgeDao?.insert(edges)
                pathDao?.insert(pathways)

                pathCallback?.onSuccessFromLocal(
                    referencePlace.id,
                    destinationId, getPathLength(steps),
                    referencePlace, steps
                )

        }
    }

    private fun getPathLength(steps: List<Step>): Int {
        var pathLength: Int = 0
        for (step in steps)
            pathLength += step.edge.distance
        return pathLength
    }
}