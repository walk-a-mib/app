package com.example.walk_a_mib.ui

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.walk_a_mib.R

class OtherInfo(val context: Context) {

    fun addOtherInformation(linearLayout: LinearLayout, name: String, value: String) {
        if (
            (name == "available" && value == "false")
            || name == "accessible"
            || name == "indoor"
            || name == "building"
            || name == "floor"
        ) {

            LayoutInflater.from(context).inflate(R.layout.other_info_poi, linearLayout, true)

            val cardView = linearLayout.getChildAt(linearLayout.childCount - 1) as CardView
            val constraintLayout = cardView.getChildAt(0) as ConstraintLayout
            val img = constraintLayout.getChildAt(0) as ImageView
            val txt = constraintLayout.getChildAt(1) as TextView

            when (name) {
                "available" -> {
                    addIconAndTextInBottomSheet(
                        cardView,
                        R.color.errorBg,
                        img,
                        R.drawable.ic_warning,
                        txt,
                        R.color.errorTextOnBg,
                        context.resources.getString(R.string.poi_not_working)
                    )
                }
                "accessible" -> {
                    if (value == "true") {
                        addIconAndTextInBottomSheet(
                            cardView,
                            R.color.otherInfoBg,
                            img,
                            R.drawable.ic_accessible_icon,
                            txt,
                            R.color.otherInfoTextOnBg,
                            context.resources.getString(R.string.poi_accessible)
                        )
                    } else {
                        addIconAndTextInBottomSheet(
                            cardView,
                            R.color.errorBg,
                            img,
                            R.drawable.ic_round_not_accessible_24,
                            txt,
                            R.color.errorTextOnBg,
                            context.resources.getString(R.string.poi_not_accessible)
                        )
                    }
                }
                "indoor" -> {
                    if (value == "true") {
                        addIconAndTextInBottomSheet(
                            cardView,
                            R.color.otherInfoBg,
                            img,
                            R.drawable.indoor,
                            txt,
                            R.color.otherInfoTextOnBg,
                            context.resources.getString(R.string.poi_indoor)
                        )
                    } else {
                        addIconAndTextInBottomSheet(
                            cardView,
                            R.color.otherInfoBg,
                            img,
                            R.drawable.outdoor,
                            txt,
                            R.color.otherInfoTextOnBg,
                            context.resources.getString(R.string.poi_outdoor)
                        )
                    }
                }
                "building" -> {
                    addIconAndTextInBottomSheet(
                        cardView,
                        R.color.otherInfoBg,
                        img,
                        R.drawable.ic_building_24,
                        txt,
                        R.color.otherInfoTextOnBg,
                        context.resources.getString(R.string.building, value)
                    )
                }
                "floor" -> {
                    addIconAndTextInBottomSheet(
                        cardView,
                        R.color.otherInfoBg,
                        img,
                        R.drawable.ic_floor,
                        txt,
                        R.color.otherInfoTextOnBg,
                        context.resources.getString(R.string.floor, value)
                    )
                }
            }
        }
    }

    private fun addIconAndTextInBottomSheet(
        cardView: CardView,
        colorCardView: Int,
        img: ImageView,
        imgIcon: Int,
        txt: TextView,
        txtColorAndTextIcon: Int,
        txtText: String
    ) {
        cardView.setCardBackgroundColor(
            ContextCompat.getColor(context, colorCardView)
        )
        img.setImageDrawable(
            ContextCompat.getDrawable(context, imgIcon)
        )
        DrawableCompat.setTint(
            DrawableCompat.wrap(img.drawable),
            ContextCompat.getColor(context, txtColorAndTextIcon)
        )
        txt.setTextColor(
            ContextCompat.getColor(context, txtColorAndTextIcon)
        )
        txt.text = txtText
    }

}