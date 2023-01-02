package com.example.walk_a_mib.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.walk_a_mib.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    override fun finish() {
        super.finish()

//        overridePendingTransition(
//            R.anim.slide_in_right,
//            R.anim.slide_out_left
//        )
    }
}