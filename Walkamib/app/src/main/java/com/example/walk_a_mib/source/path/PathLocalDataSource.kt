package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.database.EdgeDao
import com.example.walk_a_mib.database.MapsRoomDatabase
import com.example.walk_a_mib.database.PathDao
import com.example.walk_a_mib.database.NodeDao
import com.example.walk_a_mib.database.relationship.Pathway
import com.example.walk_a_mib.logic_layer.domain.Edge
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.path.Step

class PathLocalDataSource(val mapsRoomDatabase: MapsRoomDatabase) : BasePathLocalDataSource() {
    val pathDao: PathDao = mapsRoomDatabase.pathDao()
    val placeDao : NodeDao = mapsRoomDatabase.nodeDao()
    val edgeDao : EdgeDao = mapsRoomDatabase.edgeDao()

    override fun getPath(
        referenceId: String,
        destinationId: String,
        accessibility: Boolean
    ) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            var res : List<Step> = pathDao.getPath(referenceId, destinationId, accessibility)!!
            pathCallback?.onSuccessFromLocal(
                referenceId,
                destinationId,
                accessibility,
                getPathLength(res),
                placeDao.getPlace(referenceId),
                pathDao.getPath(referenceId, destinationId, accessibility)
            )
        }
    }

    override fun insertPath(
        referencePlace: Node,
        destinationId: String,
        accessibility: Boolean,
        steps: List<Step>
    ) {
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
                    destinationId,
                    accessibility,
                    getPathLength(steps),
                    referencePlace, steps,
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