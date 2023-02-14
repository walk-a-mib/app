package com.example.walk_a_mib.source.path

import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.path.PathBodyRequest
import com.example.walk_a_mib.model.path.PathBodyResponse
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.util.Constants
import com.example.walk_a_mib.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PathRemoteDataSource(val apiKey: String): BasePathRemoteDataSource() {
    private val placeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPath(referenceId: String, destinationId: String, accessibility: Boolean) {
        val placeResponseCall : Call<GenericApiResponse<PathBodyResponse>> = placeApiService.getPath(
            PathBodyRequest(referenceId, destinationId, accessibility), apiKey)

        placeResponseCall.enqueue(object : Callback<GenericApiResponse<PathBodyResponse>> {

            override fun onResponse(call: Call<GenericApiResponse<PathBodyResponse>>, response: Response<GenericApiResponse<PathBodyResponse>>) {
                if (response.isSuccessful &&
                    !(response.body()?.status.equals("error"))
                ) {
                    pathCallback?.onSuccessFromRemote(
                        response.body()!!,
                        accessibility,
                        System.currentTimeMillis(),
                    )
                }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<PathBodyResponse>>, t: Throwable) {
                pathCallback?.onFailureFromRemote(Exception(Constants.RETROFIT_ERROR));
            }

        })

    }
}