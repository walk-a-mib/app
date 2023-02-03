package com.example.demoapiarch.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapiarch.R
import com.example.demoapiarch.model.CallResult
import com.example.demoapiarch.repository.place.IPlaceRepository
import com.example.demoapiarch.repository.placesNearby.IPlacesNearbyRepository
import com.example.demoapiarch.util.ServiceLocator


class MAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mact)


        val placeRepository: IPlaceRepository =
            ServiceLocator.getPlaceRepository(
                this.application
            )

        val placesNearbyRepository: IPlacesNearbyRepository =
            ServiceLocator.getPlacesNearbyRepository(
                this.application
            )



        val placeViewModel = ViewModelProvider(
            this,
            PlaceViewModelFactory(placeRepository, placesNearbyRepository)
        )[PlaceViewModel::class.java]

        val btn = findViewById<Button>(R.id.gobtn)


        val nameObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlace).placeResponse.place.toString()
                Log.d("MAIN", "ACTUALLY FUCKING WORKS " + res)

            } else {
                Log.d("MAIN", "FUCK NO")
            }
        }

        var places = arrayOf("30", "31",
            "32", "33")
        var counter : Int = 0;

        btn.setOnClickListener {
            var pl = places[counter]
            if (counter < 4) {
                counter++
                counter %= 4
                
                placeViewModel.fetchPlace(pl, 1000).observe(this, nameObserver)

                //TODO: gestire gli observer che hanno finito il loro compito


            }
        }











        val pnObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlacesNearby).placesNearbyResponse
                Log.d("MAIN", "ACTUALLY FUCKING WORKS PN! RP = " + res.referencePlace + " --- PN = " + res.placesNearby)
            } else {
                Log.d("MAIN", "FUCK NO PN")
            }
        }

        val pnBtn = findViewById<Button>(R.id.pnBtn)

        var referencePlaces = arrayOf("30", "31",
            "32", "33")
        var counterPn : Int = 0;


        pnBtn.setOnClickListener {
            var pl = places[counter]
            if (counter < 4) {
                counter++
                counter %= 4

                placeViewModel.fetchPlacesNearby(pl, 3000, 1000).observe(this, pnObserver)
                //TODO: gestire gli observer che hanno finito il loro compito


            }
        }





    }

}