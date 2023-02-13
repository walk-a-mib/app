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
import com.example.walk_a_mib.repository.user.IUserRepository
import com.example.walk_a_mib.repository.user.UserRepository
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
import com.example.walk_a_mib.source.user.BaseUserAuthenticationRemoteDataSource
import com.example.walk_a_mib.source.user.UserAuthenticationRemoteDataSource
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceLocator {
    @Volatile
    private var INSTANCE: ServiceLocator? = null

    private fun ServiceLocator() {}

    /**
     * Returns an instance of ServiceLocator class.
     * @return An instance of ServiceLocator.
     */
    fun getInstance(): ServiceLocator? {
        if (INSTANCE == null) {
            synchronized(ServiceLocator::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = com.example.walk_a_mib.util.ServiceLocator
                }
            }
        }
        return INSTANCE
    }

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

    /**
     * Creates an instance of IUserRepository.
     * @return An instance of IUserRepository.
     */
    fun getUserRepository(application: Application?): IUserRepository? {
//        val sharedPreferencesUtil = SharedPreferencesUtil(application)
        val userRemoteAuthenticationDataSource: BaseUserAuthenticationRemoteDataSource =
            UserAuthenticationRemoteDataSource()

        return UserRepository(userRemoteAuthenticationDataSource)
    }
}