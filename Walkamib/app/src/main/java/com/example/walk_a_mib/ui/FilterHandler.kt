package com.example.walk_a_mib.ui

import android.content.Context
import android.util.Log
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.LinearLayout
import com.example.walk_a_mib.R
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.model.placesNearby.Neighbour

class FilterHandler(val context: Context, val places: List<Neighbour>, val poiContainer: LinearLayout, val webView: WebView) {
    private val isFirstElementArrayList = arrayListOf(true, true, true, true, true, true, true, true, true)
    private val imgMap = mutableMapOf<String, ImageButton>()

    fun handlePlace() {
        var i = 0

        do {
            var stop = false
            var pos = 0 // used to cycle over isFirstElementArrayList

            while(!stop && pos < isFirstElementArrayList.size) {
                if(isFirstElementArrayList[pos]) {
                    stop = true
                }
                pos++
            }

            when(places[i].place.label) {
                "door_normal" -> {
                    if(isFirstElementArrayList[0]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_door_open_solid
                        )
                        imgMap["door_normal"] = img
                        isFirstElementArrayList[0] = false
                    }
                }
                "door_exit" -> {
                    if(isFirstElementArrayList[1]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_person_walking_arrow_right_solid
                        )
                        imgMap["door_exit"] = img
                        isFirstElementArrayList[1] = false
                    }
                }
                "stairs" -> {
                    if(isFirstElementArrayList[2]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_stairs
                        )
                        imgMap["stairs"] = img
                        isFirstElementArrayList[2] = false
                    }
                }
                "restroom_H" -> {
                    if(isFirstElementArrayList[3]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_accessible_icon
                        )
                        imgMap["restroom_H"] = img
                        isFirstElementArrayList[3] = false
                    }
                }
                "restroom_M" -> {
                    if(isFirstElementArrayList[4]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_person
                        )
                        imgMap["restroom_M"] = img
                        isFirstElementArrayList[4] = false
                    }
                }
                "restroom_F" -> {
                    if(isFirstElementArrayList[5]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_person_dress
                        )
                        imgMap["restroom_F"] = img
                        isFirstElementArrayList[5] = false
                    }
                }
                "classroom" -> {
                    if(isFirstElementArrayList[6]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_chalkboard_user
                        )
                        imgMap["classroom"] = img
                        isFirstElementArrayList[6] = false
                    }
                }
                "vending_machine_hotdrinks" -> {
                    if(isFirstElementArrayList[7]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_mug_hot
                        )
                        imgMap["vending_machine_hotdrinks"] = img
                        isFirstElementArrayList[7] = false
                    }
                }
                "vending_machine_colddrinks" -> {
                    if (isFirstElementArrayList[8]) {
                        val img = Utility.inflateAndAddIcon(
                            context, poiContainer, R.drawable.ic_bottle_water
                        )
                        imgMap["vending_machine_colddrinks"] = img
                        isFirstElementArrayList[8] = false
                    }
                }
                else -> {
                    Log.d("manca", places[i].place.label)
                }
            }

            var imgAlreadyClicked = false
            var type: String? = null
            imgMap.forEach { entry ->
                entry.value.setOnClickListener {
                    if(imgAlreadyClicked && type != null) {
                        val element = imgMap[type] // get the last clicked element before this
                        Utility.changeBgColorAndColor(context, element!!, R.color.backgroundColorPoI, R.color.colorPoI) // reset old filter color
                        JSBridge.resetFilters(webView) // reset old map filter
                        if(entry.key != type) { // clicked different filter
                            JSBridge.filterByType(webView, entry.key)
                            Utility.changeBgColorAndColor(context, entry.value, R.color.colorPoI, R.color.backgroundColorPoI)
                        } else {
                            imgAlreadyClicked = false
                        }
                    } else {
                        JSBridge.filterByType(webView, entry.key)
                        imgAlreadyClicked = true
                        Utility.changeBgColorAndColor(context, entry.value, R.color.colorPoI, R.color.backgroundColorPoI)
                    }
                    type = entry.key
                }
            }

            i++
        } while(stop && i < places.size)
    }
}