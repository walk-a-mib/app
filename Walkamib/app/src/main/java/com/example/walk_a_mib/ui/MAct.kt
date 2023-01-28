package com.example.walk_a_mib.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.walk_a_mib.R
import com.example.walk_a_mib.model.PlaceResult
import com.example.walk_a_mib.repository.IPlaceRepository
import com.example.walk_a_mib.util.ServiceLocator


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





    }

}