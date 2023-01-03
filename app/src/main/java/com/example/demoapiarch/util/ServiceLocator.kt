package com.example.demoapiarch.util

import android.app.Application
import com.example.demoapiarch.R
import com.example.demoapiarch.database.PlaceRoomDatabase
import com.example.demoapiarch.repository.IPlaceRepository
import com.example.demoapiarch.repository.PlaceRepository
import com.example.demoapiarch.service.PlaceApiService
import com.example.demoapiarch.source.BasePlaceLocalDataSource
import com.example.demoapiarch.source.BasePlaceRemoteDataSource
import com.example.demoapiarch.source.PlaceLocalDataSource
import com.example.demoapiarch.source.PlaceRemoteDataSource
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceLocator {

    fun getPlaceApiService(): PlaceApiService {
        //TODO SISTEMARE
        val gson = GsonBuilder()
            .setLenient()
            .create()
        //
        var retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.API_BASE_URL)
            .build()

        return retrofit.create(PlaceApiService::class.java)
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