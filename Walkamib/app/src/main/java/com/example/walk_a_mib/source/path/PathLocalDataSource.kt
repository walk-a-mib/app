package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.database.EdgeDao
import com.example.walk_a_mib.database.MapsRoomDatabase
import com.example.walk_a_mib.database.PathDao
import com.example.walk_a_mib.database.PlaceDao
import com.example.walk_a_mib.database.relationship.Pathway
import com.example.walk_a_mib.logic_layer.domain.Edge
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.path.Step

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