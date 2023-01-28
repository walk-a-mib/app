package com.example.walk_a_mib.model

import android.os.Parcelable
import com.google.firebase.database.Exclude
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(var name: String, var email: String, @get:Exclude var idToken: String) : Parcelable {

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", idToken='" + idToken + '\'' +
                '}'
    }
}