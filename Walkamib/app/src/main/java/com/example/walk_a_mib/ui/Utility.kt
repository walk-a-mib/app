package com.example.walk_a_mib.ui

import android.content.Context
import android.util.Patterns
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.FragmentActivity
import com.example.walk_a_mib.R
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.model.placesNearby.Neighbour
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

object Utility {

    fun inflateAndAddIcon(context: Context, container: LinearLayout, icon: Int): ImageButton {
        LayoutInflater.from(context).inflate(R.layout.poi, container, true)
        val img = container.getChildAt(container.childCount - 1) as ImageButton
        img.setImageDrawable(
            ContextCompat.getDrawable(context, icon)
        )

        return img
    }

    fun changeBgColorAndColor(context: Context, img: ImageButton, bgColor: Int, color: Int) {
        img.backgroundTintList = getColorStateList(context, bgColor)
        DrawableCompat.setTint(
            DrawableCompat.wrap(img.drawable),
            ContextCompat.getColor(context, color)
        )
    }

    fun showSnackbarError(activity: FragmentActivity, message: String) {
        return Snackbar.make(
            activity.findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    // Function to validate email
    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


    // Function to validate password
    fun isValidPasswordFormat(password: CharSequence): Boolean {
        val passwordREGEX = Pattern.compile("^" +
//                    "(?=.*[0-9])" +         //at least 1 digit
//                    "(?=.*[a-z])" +         //at least 1 lower case letter
//                    "(?=.*[A-Z])" +         //at least 1 upper case letter
//                    "(?=.*[a-zA-Z])" +      //any letter
//                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$");
        return passwordREGEX.matcher(password).matches()
    }
}