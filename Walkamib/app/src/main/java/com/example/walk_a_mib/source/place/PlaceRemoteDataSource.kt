package com.example.walk_a_mib.source.place

import android.util.Log
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.place.PlaceBodyResponse
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.util.Constants.RETROFIT_ERROR
import com.example.walk_a_mib.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceRemoteDataSource(val apiKey: String) : BasePlaceRemoteDataSource() {
    private val placeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPlace(placeId: String) {
        val placeResponseCall : Call<GenericApiResponse<PlaceBodyResponse>> = placeApiService.getPlace(placeId, apiKey)

        placeResponseCall.enqueue(object : Callback<GenericApiResponse<PlaceBodyResponse>> {
            override fun onResponse(call: Call<GenericApiResponse<PlaceBodyResponse>>, response: Response<GenericApiResponse<PlaceBodyResponse>>) {

                    if (response.isSuccessful &&
                        !(response.body()?.status.equals("error"))
                    ) {
                        placeCallback?.onSuccessFromRemote(
                            response.body()!!,
                            System.currentTimeMillis()
                        )
                    }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<PlaceBodyResponse>>, t: Throwable) {
                Log.d("MAIN", t.stackTraceToString().toString())
                placeCallback?.onFailureFromRemote(Exception(RETROFIT_ERROR));
            }

        })

    }
}