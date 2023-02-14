package com.example.walk_a_mib.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.walk_a_mib.R
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.repository.node.INodeRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.util.ServiceLocator


class MAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mact)


        val placeRepository: INodeRepository =
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
                val res = (result as CallResult.SuccessAllNodes).allNodes.nodes.toString()
                Log.d("MAIN", "ACTUALLY FUCKING WORKS ALL PLACES! " + res)

            } else {
                Log.d("MAIN", "FUCK NO ALL PLACES")
            }
        }
        mapsViewModel.fetchAllPlaces(1000).observe(this, allPlacesObserver)

        /*


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

         */


        val searchPlaceObserver = Observer<CallResult> { result ->
            if (result.isSuccess() && result is CallResult.SuccessAllNodes) {
                val res = result.allNodes
                if (res != null)
                    Log.d("MAIN", "ACTUALLY FUCKING WORKS SEARCH PLACE FROM NAME KEYWORD! " + res.nodes.toString())
                else
                    Log.d("MAIN", "NO LUCK BRO")
            } else {
                Log.d("MAIN", "FUCK NO PN")
            }
        }

        val srcKeyBtn = findViewById<Button>(R.id.gobtn)




        //srcKeyBtn.setOnClickListener {
        //    mapsViewModel.searchPlaceFromNameKeyword("x", 1000).observe(this, searchPlaceObserver)

        //}



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


        srcKeyBtn.setOnClickListener {
            mapsViewModel.fetchPath("3", "30", 1000).observe(this, fpObserver)

        }






    }

}