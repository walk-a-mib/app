package com.example.walk_a_mib.repository.path
import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.GenericApiResponse
import com.example.walk_a_mib.model.placesNearby.Neighbour
import com.example.walk_a_mib.model.placesNearby.PlacesNearbyBodyResponse
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.source.callback.PlacesNearbyCallback
import com.example.walk_a_mib.source.placesNearby.BasePlacesNearbyLocalDataSource
import com.example.walk_a_mib.source.placesNearby.BasePlacesNearbyRemoteDataSource

class PlacesNearbyRepository(val placesNearbyRemoteDataSource: BasePlacesNearbyRemoteDataSource,
                             val placesNearbyLocalDataSource: BasePlacesNearbyLocalDataSource
                             ) : IPlacesNearbyRepository, PlacesNearbyCallback
{
    val TAG: String = PlacesNearbyRepository::class.java.simpleName
    val allPlacesNearby: MutableLiveData<CallResult> = MutableLiveData<CallResult>().apply { postValue(
        CallResult()
    )}

    var choice = true

    init {
        placesNearbyRemoteDataSource.placeNearbyCallback = this
        placesNearbyLocalDataSource.placeNearbyCallback = this
    }

    override fun fetchPlacesNearby(referencePlaceId: String, maxDistance: Int, lastUpdate: Long): MutableLiveData<CallResult> {
        val currentTime = System.currentTimeMillis()

        //if (choice) { //(currentTime - lastUpdate > Constants.FRESH_TIMEOUT)
        //    placeRemoteDataSource.getPlace(placeId)
        //    choice = false
        //}
        //else
        //    placeLocalDataSource.getPlace(placeId)
        //TODO: condizione se non è passato troppo tempo
        placesNearbyLocalDataSource.getPlacesNearby(referencePlaceId, maxDistance)
        return allPlacesNearby
    }

    private fun fetchFromRemote(referencePlaceId: String, maxDistance: Int) {
        placesNearbyRemoteDataSource.getPlacesNearby(referencePlaceId, maxDistance)
    }

    override fun onSuccessFromRemote(
        apiResponse: GenericApiResponse<PlacesNearbyBodyResponse>,
        maxDistance: Int,
        lastUpdate: Long
    ) {
        placesNearbyLocalDataSource.insertPlacesNearby(apiResponse.responseBody.referencePlace, maxDistance, apiResponse.responseBody.placesNearby)
    }

    override fun onFailureFromRemote(exception: Exception) {
        val result: CallResult.Error = CallResult.Error(exception.message)
        allPlacesNearby.postValue(result)
    }

    override fun onSuccessFromLocal(referencePlaceId: String,
                                    maxDistance: Int,
                                    referencePlace: Node?,
                                    neighbours: List<Neighbour>?) {
        if (referencePlace != null && neighbours?.size!! > 0) {
            var result = CallResult.SuccessPlacesNearby(PlacesNearbyBodyResponse(referencePlace, neighbours!!))
            allPlacesNearby.postValue(result!!)
        } else {
            fetchFromRemote(referencePlaceId, maxDistance)
        }
    }

    override fun onFailureFromLocal(exception: Exception) {
        val resultError: CallResult.Error = CallResult.Error(exception.message)
        allPlacesNearby.postValue(resultError)
    }

}