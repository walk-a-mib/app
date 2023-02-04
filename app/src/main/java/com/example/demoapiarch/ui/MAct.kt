package com.example.demoapiarch.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapiarch.R
import com.example.demoapiarch.model.CallResult
import com.example.demoapiarch.repository.path.IPathRepository
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

        val pathRepository: IPathRepository =
            ServiceLocator.getPathRepository(
                this.application
            )

        val mapsViewModel = ViewModelProvider(
            this,
            MapsViewModelFactory(placeRepository, placesNearbyRepository, pathRepository)
        )[MapsViewModel::class.java]


        val allPlacesObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessAllPlaces).allPlaces.toString()
                Log.d("MAIN", "ACTUALLY FUCKING WORKS ALL PLACES! " + res)

            } else {
                Log.d("MAIN", "FUCK NO ALL PLACES")
            }
        }
        mapsViewModel.fetchAllPlaces(1000).observe(this, allPlacesObserver)




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
                
                mapsViewModel.fetchPlace(pl, 1000).observe(this, nameObserver)

                //TODO: gestire gli observer che hanno finito il loro compito
            }
        }






        val fp = findViewById<Button>(R.id.fPath)

        val fpObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPath).pathResponse
                Log.d("MAIN",
                    "ACTUALLY FUCKING WORKS FIND PATH: " + res.pathLength + " --- "
                            + res.nodeList.toString() + " --- " + res.edgeList.toString())

            } else {
                Log.d("MAIN", "FUCK NO FIND PATH")
            }
        }

        var destinations = arrayOf("26", "27", "28", "29")
        var counterFP : Int = 0;

        fp.setOnClickListener {
            var pl = places[counter]
            var dest = destinations[counterFP]

            if (counterFP < 4) {
                counterFP++
                counterFP %= 4

                mapsViewModel.fetchPath(pl, dest, 1000).observe(this, fpObserver)

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

                mapsViewModel.fetchPlacesNearby(pl, 3000, 1000).observe(this, pnObserver)
                //TODO: gestire gli observer che hanno finito il loro compito


            }
        }





    }

}