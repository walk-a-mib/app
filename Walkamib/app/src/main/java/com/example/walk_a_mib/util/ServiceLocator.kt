package com.example.walk_a_mib.util

import android.app.Application
import com.example.walk_a_mib.R
import com.example.walk_a_mib.database.MapsRoomDatabase
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.repository.path.PathRepository
import com.example.walk_a_mib.repository.path.PlacesNearbyRepository
import com.example.walk_a_mib.repository.place.IPlaceRepository
import com.example.walk_a_mib.repository.place.PlaceRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.service.MapsApiService
import com.example.walk_a_mib.source.path.BasePathLocalDataSource
import com.example.walk_a_mib.source.path.BasePathRemoteDataSource
import com.example.walk_a_mib.source.path.PathLocalDataSource
import com.example.walk_a_mib.source.path.PathRemoteDataSource
import com.example.walk_a_mib.source.place.BasePlaceLocalDataSource
import com.example.walk_a_mib.source.place.BasePlaceRemoteDataSource
import com.example.walk_a_mib.source.place.PlaceLocalDataSource
import com.example.walk_a_mib.source.place.PlaceRemoteDataSource
import com.example.walk_a_mib.source.placesNearby.BasePlacesNearbyLocalDataSource
import com.example.walk_a_mib.source.placesNearby.BasePlacesNearbyRemoteDataSource
import com.example.walk_a_mib.source.placesNearby.PlacesNearbyLocalDataSource
import com.example.walk_a_mib.source.placesNearby.PlacesNearbyRemoteDataSource
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

    fun getPathRepository(application: Application): IPathRepository {
        val pathRemoteDataSource: BasePathRemoteDataSource = PathRemoteDataSource(application.getString(
            R.string.maps_api_key))
        val pathLocalDataSource: BasePathLocalDataSource = PathLocalDataSource(getDao(application))

        return PathRepository(pathRemoteDataSource, pathLocalDataSource)
    }
}