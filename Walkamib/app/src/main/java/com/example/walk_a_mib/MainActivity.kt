package com.example.walk_a_mib

import android.animation.LayoutTransition
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<Route>
    lateinit var svgId : Array<Int>
    lateinit var description: Array<String>
    lateinit var distance: Array<String>

    // allows us to convert px in dp and vice versa
    fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = findViewById<CardView>(R.id.settings)
        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
//            overridePendingTransition(
//                R.anim.slide_in_top,
//                R.anim.slide_out_bottom
//            )

            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )

        }

        BottomSheetBehavior.from(sheet).apply {
            peekHeight = 60.toPx()
            this.isHideable = true
            this.state = BottomSheetBehavior.STATE_HIDDEN
        }

        imgBtn1.setOnClickListener {
            if(BottomSheetBehavior.from(sheet).state != BottomSheetBehavior.STATE_COLLAPSED) {
                BottomSheetBehavior.from(sheet).apply {
                    peekHeight = 60.toPx()
                    this.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }
        }

        // this line of code below allows us to modify margins
        var param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams

        // this line of code below allows changes to be animated
        mapLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        BottomSheetBehavior.from(sheet).addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        param.bottomMargin = 60.toPx()
                        mapLayout.layoutParams = param
                    }

                    BottomSheetBehavior.STATE_HIDDEN -> {
                        param.bottomMargin = 0
                        mapLayout.layoutParams = param
                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

       setUpRoutes() // adds elements inside RecyclerView
    }

    private fun setUpRoutes() {
        svgId = arrayOf(
            R.drawable.ic_round_straight_24,
            R.drawable.ic_round_turn_left_24,
            R.drawable.ic_round_turn_right_24
        )

        description = arrayOf(
            getString(R.string.straight),
            getString(R.string.turn_left),
            getString(R.string.turn_right)
        )

        distance = arrayOf(
            "50mt",
            "127mt",
            "91mt"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in svgId.indices) {
            val route = Route(svgId[i], description[i], distance[i])
            newArrayList.add(route)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}
