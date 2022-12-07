package com.example.walk_a_mib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<Route>
    lateinit var svgId : Array<Int>
    lateinit var description: Array<String>

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
            peekHeight = 175
            this.isHideable = true
            this.state = BottomSheetBehavior.STATE_HIDDEN
        }

        imgBtn1.setOnClickListener {
            if(BottomSheetBehavior.from(sheet).state != 4) {
                // if bottomsheet is already collapsed ignore this piece code
                BottomSheetBehavior.from(sheet).apply {
                    peekHeight = 175
                    this.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }
        }

        svgId = arrayOf(
            R.drawable.squidward,
            R.drawable.squidward2
        )

        description = arrayOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()

    }

    private fun getUserdata() {
        for(i in svgId.indices) {
            val route = Route(svgId[i], description[i])
            newArrayList.add(route)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}