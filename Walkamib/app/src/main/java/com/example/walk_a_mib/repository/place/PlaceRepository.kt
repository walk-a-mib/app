package com.example.walk_a_mib.repository.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.place.AllPlacesBodyResponse
import com.example.walk_a_mib.model.place.PlaceBodyResponse
import com.example.walk_a_mib.source.callbacks.AllPlacesCallback
import com.example.walk_a_mib.source.callbacks.PlaceCallback
import com.example.walk_a_mib.source.place.BasePlaceLocalDataSource
import com.example.walk_a_mib.source.place.BasePlaceRemoteDataSource

class PlaceRepository(val placeRemoteDataSource: BasePlaceRemoteDataSource,
                      val placeLocalDataSource: BasePlaceLocalDataSource
) : IPlaceRepository, PlaceCallback, AllPlacesCallback {
    val TAG: String = PlaceRepository::class.java.simpleName
    val place: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    val allPlaces: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        placeRemoteDataSource.placeCallback = this
        placeLocalDataSource.placeCallback = this
        placeLocalDataSource.allPlacesCallback = this
        placeRemoteDataSource.allPlacesCallback = this
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
        return place
    }

    override fun fetchAllPlaces(): MutableLiveData<CallResult>? {
        val currentTime = System.currentTimeMillis()

        placeLocalDataSource.getAllPlaces()
        return allPlaces
    }

    private fun fetchAllPlacesFromRemote() {
        placeRemoteDataSource.getAllPlaces()
    }

    private fun fetchPlaceFromRemote(placeId: String) {
        placeRemoteDataSource.getPlace(placeId)
    }

    override fun onSuccessFromRemotePlace(apiResponse: GenericApiResponse<PlaceBodyResponse>,
                                          lastUpdate: Long) {
        placeLocalDataSource.insertPlace(apiResponse.responseBody.place)
    }

    override fun onSuccessFromLocal(places: List<Node>?) {
        if (places != null && places.isNotEmpty()) {
            var result = CallResult.SuccessAllPlaces(AllPlacesBodyResponse(places!!))
            this.allPlaces.postValue(result!!)
            Log.d("MAIN", "finitop")
        }
        else
            fetchAllPlacesFromRemote()
    }

    override fun onSuccessFromRemoteAllPlaces(
        apiResponse: GenericApiResponse<AllPlacesBodyResponse>,
        lastUpdate: Long
    ) {
        placeLocalDataSource.insertPlaces(apiResponse.responseBody.places)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: CallResult.Error = CallResult.Error(exception.message)
        place.postValue(result)
    }

    override fun onSuccessFromLocal(reqId: String, place: Node?) {
        if (place != null) {
            var result = CallResult.SuccessPlace(PlaceBodyResponse(place!!))
            this.place.postValue(result!!)
        }
        else
            fetchPlaceFromRemote(reqId)
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        place.postValue(resultError)
    }

}