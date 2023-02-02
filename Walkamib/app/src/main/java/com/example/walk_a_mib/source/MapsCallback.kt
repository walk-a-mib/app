package com.example.walk_a_mib.source

interface MapsCallback {
    fun onFailureFromRemote(exception: Exception)
    fun onFailureFromLocal(exception: Exception)
}