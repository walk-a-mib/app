package com.example.demoapiarch.source

interface MapsCallback {
    fun onFailureFromRemote(exception: Exception)
    fun onFailureFromLocal(exception: Exception)
}