package com.example.walk_a_mib.source.placesNearby

import android.util.Log
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.util.Constants
import com.example.walk_a_mib.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlacesNearbyRemoteDataSource(val apiKey: String): BasePlacesNearbyRemoteDataSource() {
    private val placeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPlacesNearby(referenceId : String, maxDistance: Int) {
        val placeResponseCall : Call<GenericApiResponse<PlacesNearbyBodyResponse>> = placeApiService.getPlacesNearby(referenceId, maxDistance, apiKey)

        placeResponseCall.enqueue(object : Callback<GenericApiResponse<PlacesNearbyBodyResponse>> {
            override fun onResponse(call: Call<GenericApiResponse<PlacesNearbyBodyResponse>>, response: Response<GenericApiResponse<PlacesNearbyBodyResponse>>) {
                if (response.isSuccessful &&
                    !(response.body()?.status.equals("error"))
                ) {
                    placeNearbyCallback?.onSuccessFromRemote(
                        response.body()!!,
                        maxDistance,
                        System.currentTimeMillis()
                    )
                }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<PlacesNearbyBodyResponse>>, t: Throwable) {
                Log.d("MAIN", t.stackTraceToString())
                placeNearbyCallback?.onFailureFromRemote(Exception(Constants.RETROFIT_ERROR));
            }

        })

    }
}