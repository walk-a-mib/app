package com.example.walk_a_mib.repository

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.PlaceApiResponse
import com.example.walk_a_mib.model.PlaceResponse
import com.example.walk_a_mib.model.PlaceResult
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.source.BasePlaceLocalDataSource
import com.example.walk_a_mib.source.BasePlaceRemoteDataSource
import com.example.walk_a_mib.source.PlaceCallback


class PlaceRepository(val placeRemoteDataSource: BasePlaceRemoteDataSource,
                      val placeLocalDataSource: BasePlaceLocalDataSource
) : IPlaceRepository, PlaceCallback {
    val TAG: String = PlaceRepository::class.java.simpleName
    val allRequiredPlaces: MutableLiveData<PlaceResult> = MutableLiveData<PlaceResult>().apply { postValue(
        PlaceResult()
    )}

    var choice = true

    init {
        placeRemoteDataSource.placeCallback = this
        placeLocalDataSource.placeCallback = this
    }

    override fun fetchPlace(placeId: String, lastUpdate: Long): MutableLiveData<PlaceResult> {
        val currentTime = System.currentTimeMillis()

        //if (choice) { //(currentTime - lastUpdate > Constants.FRESH_TIMEOUT)
        //    placeRemoteDataSource.getPlace(placeId)
        //    choice = false
        //}
        //else
        //    placeLocalDataSource.getPlace(placeId)
        //TODO: condizione se non è passato troppo tempo
        placeLocalDataSource.getPlace(placeId)
        return allRequiredPlaces
    }

    private fun fetchFromRemote(placeId: String) {
        placeRemoteDataSource.getPlace(placeId)
    }

    override fun onSuccessFromRemote(placeApiResponse: PlaceApiResponse, lastUpdate: Long) {
        placeLocalDataSource.insertPlace(placeApiResponse.place!!)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: PlaceResult.Error = PlaceResult.Error(exception.message)
        allRequiredPlaces.postValue(result)
    }

    override fun onSuccessFromLocal(reqId: String, place: Node?) {
        val result = PlaceResult.Success(PlaceResponse(place))
        if (result.placeResponse.place != null)
            allRequiredPlaces.postValue(result)
        else
            fetchFromRemote(reqId)
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: PlaceResult.Error = PlaceResult.Error(exception.message)
        allRequiredPlaces.postValue(resultError)
    }

}