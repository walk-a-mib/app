package com.example.demoapiarch.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.demoapiarch.place.PlaceApiResponse
import com.example.demoapiarch.place.PlaceResponse
import com.example.demoapiarch.place.PlaceResult
import com.example.demoapiarch.domain.Node
import com.example.demoapiarch.source.BasePlaceLocalDataSource
import com.example.demoapiarch.source.BasePlaceRemoteDataSource
import com.example.demoapiarch.source.PlaceCallback


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
        val localRes = placeLocalDataSource.getPlace(placeId)
        if (localRes == null) {
            Log.d("MAIN", "NO LOCAL RESULT. FETCHING FROM REMOTE...")
            placeRemoteDataSource.getPlace(placeId)
        }
        return allRequiredPlaces
    }

    override fun onSuccessFromRemote(placeApiResponse: PlaceApiResponse, lastUpdate: Long) {
        placeLocalDataSource.insertPlace(placeApiResponse.place!!)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: PlaceResult.Error = PlaceResult.Error(exception.message)
        allRequiredPlaces.postValue(result)
    }

    override fun onSuccessFromLocal(place: Node) {
        val result = PlaceResult.Success(PlaceResponse(place))
        allRequiredPlaces.postValue(result)
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: PlaceResult.Error = PlaceResult.Error(exception.message)
        allRequiredPlaces.postValue(resultError)
    }

}