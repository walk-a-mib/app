package com.example.walk_a_mib.ui

import android.content.Context
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.content.ContextCompat
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

    fun toggleClick(context: Context, webview: WebView, isClicked: Boolean, type: String, img: ImageButton): Boolean {
        if(!isClicked) {
            JSBridge.filterByType(webview, type)
            return true
        } else {
            JSBridge.resetFilters(webview)
            return false
        }
    }

    fun changeColor(context: Context, img: ImageButton, colorClicked: Int, isClicked: Boolean) {
        img.backgroundTintList = getColorStateList(context, colorClicked)
    }

    fun resetColors(context: Context, imgMap: MutableMap<String, ImageButton>, color: Int) {
        for((k, v) in imgMap) {
            v.backgroundTintList = AppCompatResources.getColorStateList(context, R.color.backgroundColorPoI)
        }
    }
}