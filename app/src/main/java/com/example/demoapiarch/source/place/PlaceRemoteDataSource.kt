package com.example.demoapiarch.source.place

import android.util.Log
import com.example.demoapiarch.model.GenericApiResponse
import com.example.demoapiarch.model.place.AllPlacesBodyResponse
import com.example.demoapiarch.model.place.PlaceBodyResponse
import com.example.demoapiarch.service.MapsApiService
import com.example.demoapiarch.util.Constants.RETROFIT_ERROR
import com.example.demoapiarch.util.ServiceLocator
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
                        placeCallback?.onSuccessFromRemotePlace(
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

    override fun getAllPlaces() {
        val allPlacesResponseCall : Call<GenericApiResponse<AllPlacesBodyResponse>> = placeApiService.getAllPlaces(apiKey)

        allPlacesResponseCall.enqueue(object : Callback<GenericApiResponse<AllPlacesBodyResponse>> {
            override fun onResponse(call: Call<GenericApiResponse<AllPlacesBodyResponse>>, response: Response<GenericApiResponse<AllPlacesBodyResponse>>) {

                if (response.isSuccessful &&
                    !(response.body()?.status.equals("error"))
                ) {
                    allPlacesCallback?.onSuccessFromRemoteAllPlaces(
                        response.body()!!,
                        System.currentTimeMillis()
                    )
                }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<AllPlacesBodyResponse>>, t: Throwable) {
                allPlacesCallback?.onFailureFromRemote(Exception(RETROFIT_ERROR));
            }

        })
    }
}