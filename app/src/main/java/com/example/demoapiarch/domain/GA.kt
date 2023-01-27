package com.example.demoapiarch.domain

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class GA(var available: Boolean, var accessible: Boolean, var indoor: Boolean, var building: Int, var floor: Int) : Parcelable {

    //var image: String? = null

    override fun toString(): String {
        return "GA($available;$accessible;$indoor;$building;$floor)";
    }

}