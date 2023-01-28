package com.example.walk_a_mib.model

open class PlaceResult {
    fun isSuccess(): Boolean {
        return this is Success
    }

    class Success(val placeResponse: PlaceResponse) : PlaceResult()
    class Error(val message: String?) : PlaceResult()

    override fun toString(): String {
        if (isSuccess())
            return (this as Success).placeResponse.place.toString()
        return ""
    }
}