package com.example.walk_a_mib.repository.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.place.PlaceBodyResponse

import com.example.demoapiarch.source.callbacks.PlaceCallback
import com.example.demoapiarch.source.place.BasePlaceLocalDataSource
import com.example.demoapiarch.source.place.BasePlaceRemoteDataSource
import kotlin.reflect.typeOf

class PlaceRepository(val placeRemoteDataSource: BasePlaceRemoteDataSource,
                      val placeLocalDataSource: BasePlaceLocalDataSource
) : IPlaceRepository, PlaceCallback {
    val TAG: String = PlaceRepository::class.java.simpleName
    val allRequiredPlaces: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        placeRemoteDataSource.placeCallback = this
        placeLocalDataSource.placeCallback = this
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
        placeLocalDataSource.getPlace(placeId)
        return allRequiredPlaces
    }

    private fun fetchFromRemote(placeId: String) {
        placeRemoteDataSource.getPlace(placeId)
    }

    override fun onSuccessFromRemote(apiResponse: GenericApiResponse<PlaceBodyResponse>, lastUpdate: Long) {
        placeLocalDataSource.insertPlace(apiResponse.responseBody.place)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: CallResult.Error = CallResult.Error(exception.message)
        allRequiredPlaces.postValue(result)
    }

    override fun onSuccessFromLocal(reqId: String, place: Node?) {
        if (place != null) {
            var result = CallResult.SuccessPlace(PlaceBodyResponse(place!!))
            allRequiredPlaces.postValue(result!!)
        }
        else
            fetchFromRemote(reqId)
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        allRequiredPlaces.postValue(resultError)
    }

}