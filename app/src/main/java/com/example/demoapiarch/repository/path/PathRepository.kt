package com.example.demoapiarch.repository.path

import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.domain.Edge
import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.domain.Path
import com.example.demoapiarch.model.CallResult
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.path.PathBodyResponse
import com.example.demoapiarch.model.path.Step
import com.example.demoapiarch.source.callbacks.PathCallback
import com.example.demoapiarch.source.path.BasePathLocalDataSource
import com.example.demoapiarch.source.path.BasePathRemoteDataSource

class PathRepository(val pathRemoteDataSource: BasePathRemoteDataSource,
                     val pathLocalDataSource: BasePathLocalDataSource
) : IPathRepository, PathCallback {

    val TAG: String = PathRepository::class.java.simpleName
    val allPaths: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        pathRemoteDataSource.pathCallback = this
        pathLocalDataSource.pathCallback = this
    }

    override fun findPath(referencePlaceId: String, destinationPlaceId: String, lastUpdate: Long): MutableLiveData<CallResult> {
        val currentTime = System.currentTimeMillis()

        //if (choice) { //(currentTime - lastUpdate > Constants.FRESH_TIMEOUT)
        //    placeRemoteDataSource.getPlace(placeId)
        //    choice = false
        //}
        //else
        //    placeLocalDataSource.getPlace(placeId)
        //TODO: condizione se non è passato troppo tempo
        pathLocalDataSource.getPath(referencePlaceId, destinationPlaceId)
        return allPaths
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
        allPaths.postValue(result)
    }

    override fun onSuccessFromLocal(referenceId: String,
                                    destinationId: String,
                                    distance: Int,
                                    referencePlace: Node?,
                                    steps: List<Step>?) {
        if (referencePlace != null && steps?.size!! > 0) {
            var result = CallResult.SuccessPath(buildPath(distance, referencePlace, steps))
            allPaths.postValue(result!!)
        } else {
            fetchFromRemote(referenceId, destinationId)
        }
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        allPaths.postValue(resultError)
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