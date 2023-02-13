package com.example.walk_a_mib.repository.node

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.node.AllNodesBodyResponse
import com.example.walk_a_mib.model.node.PlaceBodyResponse
import com.example.walk_a_mib.source.callback.AllNodesCallback
import com.example.walk_a_mib.source.callback.PlaceCallback
import com.example.walk_a_mib.source.node.BaseNodeLocalDataSource
import com.example.walk_a_mib.source.node.BaseNodeRemoteDataSource

class NodeRepository(val nodeRemoteDataSource: BaseNodeRemoteDataSource,
                     val nodeLocalDataSource: BaseNodeLocalDataSource
) : INodeRepository, PlaceCallback, AllNodesCallback {
    val TAG: String = NodeRepository::class.java.simpleName

    val fetchedPlaces: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        nodeRemoteDataSource.placeCallback = this
        nodeLocalDataSource.placeCallback = this
        nodeLocalDataSource.allNodesCallback = this
        nodeRemoteDataSource.allNodesCallback = this
    }

    override fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<CallResult> {
        val currentTime = System.currentTimeMillis()

        //if (choice) { //(currentTime - lastUpdate > Constants.FRESH_TIMEOUT)
        //    placeRemoteDataSource.getPlace(placeId)
        //    choice = false
        //}
        //else
        //    placeLocalDataSource.getPlace(placeId)
        //TODO: condizione se non è passato troppo tempo
        nodeLocalDataSource.getPlace(placeId)
        return fetchedPlaces
    }

    override fun fetchAllNodes(): MutableLiveData<CallResult>? {
        val currentTime = System.currentTimeMillis()

        nodeLocalDataSource.getAllNodes()
        return fetchedPlaces
    }

    override fun searchForPlace(keyword: String): MutableLiveData<CallResult>? {
        nodeLocalDataSource.getPlacesFromNameKeyword(keyword)

        return fetchedPlaces
    }

    private fun fetchAllPlacesFromRemote() {
        nodeRemoteDataSource.getAllNodes()
    }

    private fun fetchPlaceFromRemote(placeId: String) {
        nodeRemoteDataSource.getPlace(placeId)
    }

    override fun onSuccessFromRemotePlace(apiResponse: GenericApiResponse<PlaceBodyResponse>,
                                          lastUpdate: Long) {
        nodeLocalDataSource.insertPlace(apiResponse.responseBody.place)
    }

    override fun onSuccessFromLocal(nodes: List<Node>?) {
        if (nodes != null && nodes.isNotEmpty()) {
            var result = CallResult.SuccessAllPlaces(AllNodesBodyResponse(nodes!!))
            this.fetchedPlaces.postValue(result!!)
        }
        else
            fetchAllPlacesFromRemote()
    }

    override fun onSuccessFromRemoteAllNodes(
        apiResponse: GenericApiResponse<AllNodesBodyResponse>,
        lastUpdate: Long
    ) {
        nodeLocalDataSource.insertNodes(apiResponse.responseBody.nodes)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: CallResult.Error = CallResult.Error(exception.message)
        fetchedPlaces.postValue(result)
    }

    override fun onSuccessFromLocal(reqId: String, place: Node?) {
        if (place != null) {
            var result = CallResult.SuccessPlace(PlaceBodyResponse(place!!))
            this.fetchedPlaces.postValue(result!!)
        }
        else
            fetchPlaceFromRemote(reqId)
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        fetchedPlaces.postValue(resultError)
    }

}