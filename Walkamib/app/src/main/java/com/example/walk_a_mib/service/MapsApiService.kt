package com.example.walk_a_mib.service

import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.path.PathBodyRequest
import com.example.walk_a_mib.model.path.PathBodyResponse
import com.example.walk_a_mib.model.node.AllNodesBodyResponse
import com.example.walk_a_mib.model.node.PlaceBodyResponse
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import retrofit2.Call
import retrofit2.http.*

interface MapsApiService {
    @GET("allNodes")
    fun getAllNodes(@Header("Authorization") apiKey : String) : Call<GenericApiResponse<AllNodesBodyResponse>>

    @GET("place")
    fun getPlace(@Query("place_id") placeId : String, @Header("Authorization") apiKey : String) : Call<GenericApiResponse<PlaceBodyResponse>>

    @GET("findPlacesNearby")
    fun getPlacesNearby(@Query("reference_place_id") placeId : String,
                        @Query("max_distance") maxDistance: Int,
                        @Header("Authorization") apiKey : String) : Call<GenericApiResponse<PlacesNearbyBodyResponse>>

    @POST("findPath")
    fun getPath(@Body reqBody: PathBodyRequest,
                @Header("Authorization") apiKey : String) : Call<GenericApiResponse<PathBodyResponse>>
}