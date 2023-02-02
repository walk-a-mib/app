package com.example.walk_a_mib.service

import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.place.PlaceBodyResponse
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MapsApiService {
    @GET("place")
    fun getPlace(@Query("place_id") placeId : String, @Header("Authorization") apiKey : String) : Call<GenericApiResponse<PlaceBodyResponse>>

    @GET("findPlacesNearby")
    fun getPlacesNearby(@Query("reference_place_id") placeId : String,
                        @Query("max_distance") maxDistance: Int,
                        @Header("Authorization") apiKey : String) : Call<GenericApiResponse<PlacesNearbyBodyResponse>>
}