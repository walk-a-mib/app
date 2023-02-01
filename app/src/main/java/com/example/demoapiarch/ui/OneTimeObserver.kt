package com.example.demoapiarch.ui

import android.database.Observable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoapiarch.model.CallResult


class OneTimeObserver(var observableSource: MutableLiveData<CallResult>): Observer<CallResult> {

    override fun onChanged(result: CallResult) {
        if (result.isSuccess()) {
            val res = (result as CallResult.SuccessPlace).placeResponse.place.toString()
            Log.d("MAIN", "ACTUALLY FUCKING WORKS " + res)
        } else {
            Log.d("MAIN", "FUCK NO")
        }
        observableSource.removeObserver(this)

    }

}