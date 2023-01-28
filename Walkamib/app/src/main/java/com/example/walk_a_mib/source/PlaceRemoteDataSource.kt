package com.example.walk_a_mib.source

import android.util.Log
import com.example.walk_a_mib.model.PlaceApiResponse
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.util.Constants.RETROFIT_ERROR
import com.example.walk_a_mib.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceRemoteDataSource(val apiKey: String) : BasePlaceRemoteDataSource() {
    private val placeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPlace(placeId: String) {
        val placeResponseCall : Call<PlaceApiResponse> = placeApiService.getPlace(placeId, apiKey)

        placeResponseCall.enqueue(object : Callback<PlaceApiResponse> {
            override fun onResponse(call: Call<PlaceApiResponse>, response: Response<PlaceApiResponse>) {

                try {

                    if (response.isSuccessful &&
                        !(response.body()?.status.equals("error"))
                    ) {
                        placeCallback?.onSuccessFromRemote(
                            response.body()!!,
                            System.currentTimeMillis()
                        )
                    }
                } catch (e: Exception) {
                    Log.d("MAIN", e.message.toString())
                }
            }   //response.body()

            override fun onFailure(call: Call<PlaceApiResponse>, t: Throwable) {
                placeCallback?.onFailureFromRemote(Exception(RETROFIT_ERROR));
            }

        })

    }
}