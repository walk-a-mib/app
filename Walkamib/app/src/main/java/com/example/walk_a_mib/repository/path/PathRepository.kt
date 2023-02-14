package com.example.walk_a_mib.repository.path

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.logic_layer.domain.Edge
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.logic_layer.domain.Path
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.path.PathBodyResponse
import com.example.walk_a_mib.model.path.PathOptionalFilters
import com.example.walk_a_mib.model.path.Step
import com.example.walk_a_mib.source.callback.PathCallback
import com.example.walk_a_mib.source.path.BasePathLocalDataSource
import com.example.walk_a_mib.source.path.BasePathRemoteDataSource

class PathRepository(val pathRemoteDataSource: BasePathRemoteDataSource,
                     val pathLocalDataSource: BasePathLocalDataSource
) : IPathRepository, PathCallback {

    val TAG: String = PathRepository::class.java.simpleName
    val path: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        pathRemoteDataSource.pathCallback = this
        pathLocalDataSource.pathCallback = this
    }

    override fun findPath(
        referencePlaceId: String,
        destinationPlaceId: String,
        optionalFilters: PathOptionalFilters,
        lastUpdate: Long
    ): MutableLiveData<CallResult> {
        val currentTime = System.currentTimeMillis()

        //if (choice) { //(currentTime - lastUpdate > Constants.FRESH_TIMEOUT)
        //    placeRemoteDataSource.getPlace(placeId)
        //    choice = false
        //}
        //else
        //    placeLocalDataSource.getPlace(placeId)
        //TODO: condizione se non è passato troppo tempo
        pathLocalDataSource.getPath(referencePlaceId, destinationPlaceId, optionalFilters)
        return path
    }

    private fun fetchFromRemote(referencePlaceId: String, destinationPlaceId: String) {
        pathRemoteDataSource.getPath(referencePlaceId, destinationPlaceId)
    }

    override fun onSuccessFromRemote(
        apiResponse: GenericApiResponse<PathBodyResponse>,
        lastUpdate: Long
    ) {
        pathLocalDataSource.insertPath(apiResponse.responseBody.referencePlace,
            apiResponse.responseBody.steps.last().node.id,
            apiResponse.responseBody.steps)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: CallResult.Error = CallResult.Error(exception.message)
        path.postValue(result)
    }

    override fun onSuccessFromLocal(referenceId: String,
                                    destinationId: String,
                                    distance: Int,
                                    referencePlace: Node?,
                                    steps: List<Step>?) {
        if (referencePlace != null && steps?.size!! > 0) {
            var result = CallResult.SuccessPath(buildPath(distance, referencePlace!!, steps!!))
            path.postValue(result!!)
        } else {
            fetchFromRemote(referenceId, destinationId)
        }
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        path.postValue(resultError)
    }

    private fun buildPath(distance: Int, referencePlace: Node, steps: List<Step>): Path {
        var nodeList = arrayListOf(referencePlace)
        var edgeList = arrayListOf<Edge>()
        for (step in steps) {
            nodeList.add(step.node)
            edgeList.add(step.edge)
        }
        return Path(distance, nodeList, edgeList)
    }
}