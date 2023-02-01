package com.example.demoapiarch.util

import android.app.Application
import com.example.demoapiarch.R
import com.example.demoapiarch.database.MapsRoomDatabase
import com.example.demoapiarch.repository.place.IPlaceRepository
import com.example.demoapiarch.repository.place.PlaceRepository
import com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository
import com.example.demoapiarch.repository.placesNearby.PlacesNearbyRepository
import com.example.demoapiarch.service.MapsApiService
import com.example.demoapiarch.source.place.BasePlaceLocalDataSource
import com.example.demoapiarch.source.place.BasePlaceRemoteDataSource
import com.example.demoapiarch.source.place.PlaceLocalDataSource
import com.example.demoapiarch.source.place.PlaceRemoteDataSource
import com.example.demoapiarch.source.placesNearby.BasePlacesNearbyLocalDataSource
import com.example.demoapiarch.source.placesNearby.BasePlacesNearbyRemoteDataSource
import com.example.demoapiarch.source.placesNearby.PlacesNearbyLocalDataSource
import com.example.demoapiarch.source.placesNearby.PlacesNearbyRemoteDataSource
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceLocator {

    fun getPlaceApiService(): MapsApiService {
        //TODO SISTEMARE
        val gson = GsonBuilder()
            .setLenient()
            .create()
        //
        var retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.API_BASE_URL)
            .build()

        return retrofit.create(MapsApiService::class.java)
    }

    fun getDao(application: Application): MapsRoomDatabase {
        return MapsRoomDatabase.getDatabase(application)
    }

    fun getPlaceRepository(application: Application): IPlaceRepository {
        val placeRemoteDataSource: BasePlaceRemoteDataSource = PlaceRemoteDataSource(application.getString(
            R.string.maps_api_key))
        val placeLocalDataSource: BasePlaceLocalDataSource = PlaceLocalDataSource(getDao(application))

        return PlaceRepository(placeRemoteDataSource, placeLocalDataSource)
    }

    fun getPlacesNearbyRepository(application: Application): IPlacesNearbyRepository {
        val placesNearbyRemoteDataSource: BasePlacesNearbyRemoteDataSource = PlacesNearbyRemoteDataSource(application.getString(
            R.string.maps_api_key))
        val placesNearbyLocalDataSource: BasePlacesNearbyLocalDataSource = PlacesNearbyLocalDataSource(getDao(application))

        return PlacesNearbyRepository(placesNearbyRemoteDataSource, placesNearbyLocalDataSource)
    }
}