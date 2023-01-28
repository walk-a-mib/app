package com.example.walk_a_mib.service

import com.example.walk_a_mib.model.PlaceApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MapsApiService {
    @GET("place")
    fun getPlace(@Query("place_id") placeId : String, @Header("Authorization") apiKey : String) : Call<PlaceApiResponse>

    //@GET("findPlacesNearby")
    //fun getPlacesNearby(@Query("reference_place_id") placeId : String, @Query("max_distance") maxDistance: Int) : Call<PlacesNearbyApiResponse>
}