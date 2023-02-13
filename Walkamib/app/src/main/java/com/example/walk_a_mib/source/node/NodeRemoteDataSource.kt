package com.example.walk_a_mib.source.node

import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.node.AllNodesBodyResponse
import com.example.walk_a_mib.model.node.PlaceBodyResponse
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.util.Constants.RETROFIT_ERROR
import com.example.walk_a_mib.util.ServiceLocator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NodeRemoteDataSource(val apiKey: String) : BaseNodeRemoteDataSource() {
    private val nodeApiService : MapsApiService = ServiceLocator.getPlaceApiService()

    override fun getPlace(placeId: String) {
        val placeResponseCall : Call<GenericApiResponse<PlaceBodyResponse>> = nodeApiService.getPlace(placeId, apiKey)

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
                placeCallback?.onFailureFromRemote(Exception(RETROFIT_ERROR));
            }

        })

    }

    override fun getAllNodes() {
        val allPlacesResponseCall : Call<GenericApiResponse<AllNodesBodyResponse>> = nodeApiService.getAllNodes(apiKey)

        allPlacesResponseCall.enqueue(object : Callback<GenericApiResponse<AllNodesBodyResponse>> {
            override fun onResponse(call: Call<GenericApiResponse<AllNodesBodyResponse>>, response: Response<GenericApiResponse<AllNodesBodyResponse>>) {

                if (response.isSuccessful &&
                    !(response.body()?.status.equals("error"))
                ) {
                    allNodesCallback?.onSuccessFromRemoteAllNodes(
                        response.body()!!,
                        System.currentTimeMillis()
                    )
                }
            }   //response.body()

            override fun onFailure(call: Call<GenericApiResponse<AllNodesBodyResponse>>, t: Throwable) {
                allNodesCallback?.onFailureFromRemote(Exception(RETROFIT_ERROR));
            }

        })
    }
}