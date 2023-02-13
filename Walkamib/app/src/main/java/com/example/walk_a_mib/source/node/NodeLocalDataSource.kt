package com.example.walk_a_mib.source.node

import com.example.walk_a_mib.database.MapsRoomDatabase
import com.example.walk_a_mib.database.NodeDao
import com.example.walk_a_mib.logic_layer.domain.Node

class NodeLocalDataSource(val mapsRoomDatabase: MapsRoomDatabase) : BaseNodeLocalDataSource() {
    val nodeDao: NodeDao = mapsRoomDatabase.nodeDao()

    override fun getPlace(id: String) {
            MapsRoomDatabase.databaseWriteExecutor.execute {
                placeCallback?.onSuccessFromLocal(
                    id, nodeDao.getPlace(id)
                )

            }
    }

    override fun getAllNodes() {
        MapsRoomDatabase.databaseWriteExecutor.execute {
                var r = nodeDao.getAllNodes()
                allNodesCallback?.onSuccessFromLocal(
                    nodeDao.getAllNodes()
                )
        }
    }

    override fun insertPlace(place: Node) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            nodeDao?.insert(place!!)
            placeCallback?.onSuccessFromLocal(place.id, place)
        }

    }

    override fun insertNodes(nodes: List<Node>) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            nodeDao?.insert(nodes!!)
            allNodesCallback?.onSuccessFromLocal(nodes)
        }
    }

    override fun getPlacesFromNameKeyword(nameKeyword: String) {
        MapsRoomDatabase.databaseWriteExecutor.execute {
            var r = nodeDao?.getPlacesFromNameKeyword(nameKeyword)
            allNodesCallback?.onSuccessFromLocal(r)
        }
    }

}