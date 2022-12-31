package com.example.walk_a_mib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walk_a_mib.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    override fun finish() {
        super.finish()
//        overridePendingTransition(
//            R.anim.slide_in_bottom,
//            R.anim.slide_out_top
//        )

        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }
}