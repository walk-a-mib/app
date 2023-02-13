package com.example.walk_a_mib.model.user

import android.os.Parcelable
import com.google.firebase.database.Exclude
import android.os.Parcel

class User : Parcelable {
    var name: String?
    var email: String?

    @get:Exclude
    var idToken: String?

    constructor(name: String?, email: String?, idToken: String?) {
        this.name = name
        this.email = email
        this.idToken = idToken
    }

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", idToken='" + idToken + '\'' +
                '}'
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(email)
        dest.writeString(idToken)
    }

    fun readFromParcel(source: Parcel) {
        name = source.readString()
        email = source.readString()
        idToken = source.readString()
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        email = `in`.readString()
        idToken = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User?> = object : Parcelable.Creator<User?> {
            override fun createFromParcel(source: Parcel): User? {
                return User(source)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }
}