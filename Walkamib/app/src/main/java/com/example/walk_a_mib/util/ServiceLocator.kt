package com.example.walk_a_mib.util

import android.app.Application
import com.example.walk_a_mib.R
import com.example.walk_a_mib.database.PlaceRoomDatabase
import com.example.walk_a_mib.repository.IPlaceRepository
import com.example.walk_a_mib.repository.PlaceRepository
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.source.BasePlaceLocalDataSource
import com.example.walk_a_mib.source.BasePlaceRemoteDataSource
import com.example.walk_a_mib.source.PlaceLocalDataSource
import com.example.walk_a_mib.source.PlaceRemoteDataSource
import com.example.walk_a_mib.util.Constants
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

    fun getPlaceDao(application: Application): PlaceRoomDatabase {
        return PlaceRoomDatabase.getDatabase(application)
    }

    fun getPlaceRepository(application: Application): IPlaceRepository {
        val placeRemoteDataSource: BasePlaceRemoteDataSource = PlaceRemoteDataSource(application.getString(
            R.string.maps_api_key))
        val placeLocalDataSource: BasePlaceLocalDataSource = PlaceLocalDataSource(getPlaceDao(application))

        return PlaceRepository(placeRemoteDataSource, placeLocalDataSource)
    }
}