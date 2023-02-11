package com.example.walk_a_mib.ui

import android.content.Context
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.walk_a_mib.R
import com.example.walk_a_mib.logic_layer.domain.Node
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.model.placesNearby.Neighbour

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
}