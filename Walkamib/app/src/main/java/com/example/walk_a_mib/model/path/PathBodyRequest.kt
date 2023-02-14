package com.example.walk_a_mib.model.path

import com.google.gson.annotations.SerializedName

data class PathBodyRequest(@SerializedName("reference_place_id")  val referencePlaceId: String,
<<<<<<< HEAD
                           @SerializedName("destination_place_id")  val destinationPlaceId: String,
                           val accessibility: Boolean)
=======
                           @SerializedName("destination_place_id")  val destinationPlaceId: String)
>>>>>>> parent of 4f9128be (aggiunto filtro)
