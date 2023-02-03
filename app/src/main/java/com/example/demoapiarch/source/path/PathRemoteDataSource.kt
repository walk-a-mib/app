package com.example.demoapiarch.source.path

import android.util.Log
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.path.PathBodyRequest
import com.example.demoapiarch.model.path.PathBodyResponse
import com.example.demoapiarch.model.placesNearby.PlacesNearbyBodyResponse
import com.example.demoapiarch.service.MapsApiService
import com.example.demoapiarch.source.placesNearby.BasePlacesNearbyRemoteDataSource
import com.example.demoapiarch.util.Constants
import com.example.demoapiarch.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PathRemoteDataSource(val apiKey: String): BasePathRemoteDataSource() {
    private val placeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPath(referenceId : String, destinationId: String) {
        val placeResponseCall : Call<GenericApiResponse<PathBodyResponse>> = placeApiService.getPath(PathBodyRequest(referenceId, destinationId), apiKey)

        placeResponseCall.enqueue(object : Callback<GenericApiResponse<PathBodyResponse>> {

            override fun onResponse(call: Call<GenericApiResponse<PathBodyResponse>>, response: Response<GenericApiResponse<PathBodyResponse>>) {
                if (response.isSuccessful &&
                    !(response.body()?.status.equals("error"))
                ) {
                    pathCallback?.onSuccessFromRemote(
                        response.body()!!,
                        System.currentTimeMillis()
                    )
                }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<PathBodyResponse>>, t: Throwable) {
                Log.d("MAIN", t.stackTraceToString())
                pathCallback?.onFailureFromRemote(Exception(Constants.RETROFIT_ERROR));
            }

        })

    }
}