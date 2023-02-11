package com.example.walk_a_mib.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import com.example.walk_a_mib.R
import com.google.android.material.switchmaterial.SwitchMaterial


class SettingsActivity : AppCompatActivity() {

    private fun darkMode(boolean: Boolean) {
        when (boolean) {
            true ->
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            false ->
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
        val darkModeSwitch = findViewById<SwitchMaterial>(R.id.darkModeSwitch)
        darkModeSwitch.isChecked = sharedPreferences.getBoolean("darkModeSwitch", false)

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("darkModeSwitch", true)
                editor.apply()
                darkModeSwitch.isChecked = true
            } else {
                val editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                editor.putBoolean("darkModeSwitch", false)
                editor.apply()
                darkModeSwitch.isChecked = false
            }

            darkMode(darkModeSwitch.isChecked)
        }

        val signOutContainer = findViewById<CardView>(R.id.signOutContainer)

        signOutContainer.setOnClickListener {
            // TODO(Do something)
        }

    }

    override fun finish() {
        super.finish()
//      overridePendingTransition(
//          R.anim.slide_in_bottom,
//          R.anim.slide_out_top
//      )

        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }
}