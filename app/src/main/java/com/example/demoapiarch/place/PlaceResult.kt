package com.example.demoapiarch.place

open class PlaceResult {
    fun isSuccess(): Boolean {
        return this is Success
    }

    class Success(val placeResponse: PlaceResponse) : PlaceResult()
    class Error(val message: String?) : PlaceResult()

    override fun toString(): String {
        return "itsme"
    }
}