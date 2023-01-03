package com.example.demoapiarch.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapiarch.R
import com.example.demoapiarch.place.PlaceResult
import com.example.demoapiarch.repository.IPlaceRepository
import com.example.demoapiarch.util.ServiceLocator


class MAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mact)


        val placeRepository: IPlaceRepository =
            ServiceLocator.getPlaceRepository(
                this.application
            )



        val placeViewModel = ViewModelProvider(
            this,
            PlaceViewModelFactory(placeRepository)
        )[PlaceViewModel::class.java]

        val btn = findViewById<Button>(R.id.gobtn)


        val nameObserver = Observer<PlaceResult> { result ->
            if (result.isSuccess()) {
                val res = (result as PlaceResult.Success).placeResponse.place.toString()
                Log.d("MAIN", "ACTUALLY FUCKING WORKS " + res)
            } else {
                Log.d("MAIN", "FUCK NO")
            }
        }

        placeViewModel.place.observe(this, nameObserver)



        var places = arrayOf("fff7e512-2dbc-4bd1-8936-def34a43369d", "ec375f55-e25b-42d7-a536-b95de0a2aeaf", "498d873b-7da9-4d5b-a6ac-9d5fa29db83d")
        var counter : Int = 0;


        btn.setOnClickListener {
            //val res = placeViewModel.getPlace("ec375f55-e25b-42d7-a536-b95de0a2aeaf", 1000)
            var pl = places[counter]
            Log.d("MAIN", "CALLED: " + pl)
            Log.d("MAIN", "COUNTER: " + counter)
            if (counter <= 2)
                placeViewModel.fetchPlace(pl, 1000)


            counter++
            counter %= 3
            //val r = (res as PlaceResult.Success).placeResponse.place.toString()
            //Log.d("MAIN", r)
        }

    }

}