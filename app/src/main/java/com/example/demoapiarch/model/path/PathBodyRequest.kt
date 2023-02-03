package com.example.demoapiarch.model.path

import com.google.gson.annotations.SerializedName

data class PathBodyRequest(@SerializedName("reference_place_id")  val referencePlaceId: String,
                           @SerializedName("destination_place_id")  val destinationPlaceId: String)