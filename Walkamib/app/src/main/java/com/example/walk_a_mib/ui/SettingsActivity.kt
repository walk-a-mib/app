package com.example.walk_a_mib.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.walk_a_mib.MainActivity
import com.example.walk_a_mib.R
import com.google.android.material.snackbar.Snackbar
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

        val darkMode = findViewById<ConstraintLayout>(R.id.darkMode)

        darkMode.setOnClickListener {
            darkModeSwitch.isChecked = !darkModeSwitch.isChecked
        }

        val accessiblePath = findViewById<ConstraintLayout>(R.id.accessiblePath)
        val accessiblePathSwitch = findViewById<SwitchMaterial>(R.id.accessibleSwitch)

        accessiblePath.setOnClickListener {
            accessiblePathSwitch.isChecked = !accessiblePathSwitch.isChecked
        }

        val updateMap = findViewById<ConstraintLayout>(R.id.updateMap)

        updateMap.setOnClickListener {
            // TODO(Do something)
        }

        val signOutContainer = findViewById<ConstraintLayout>(R.id.signOut)

        signOutContainer.setOnClickListener {
            startActivity(Intent(applicationContext, SignInActivity::class.java))
            finish()
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