package com.example.walk_a_mib

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walk_a_mib.adapter.RouteAdapter
import com.example.walk_a_mib.ui.SettingsActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


// allows us to convert px in dp and vice versa
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

val BOTTOMSHEET_HEIGHT = 65.toPx()

class MainActivity : AppCompatActivity() {

    private lateinit var newArrayList : ArrayList<Route>
    private lateinit var svgId : Array<Int>
    private lateinit var description: Array<String>
    private lateinit var distance: Array<String>

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
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))

        createWebView()
        onBackPressedDispatcher.addCallback(this) {
            if (webview.canGoBack()) {
                webview.goBack()
            }
        }

        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }

        BottomSheetBehavior.from(sheet).apply {
            peekHeight = BOTTOMSHEET_HEIGHT
            this.isHideable = true
            this.state = BottomSheetBehavior.STATE_HIDDEN
            bottomsheetMaterialCardView.layoutParams.height = BOTTOMSHEET_HEIGHT
        }

        // this line of code below allows us to modify margins
        val param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams
//        param.bottomMargin = BOTTOMSHEET_HEIGHT
        // these lines of code below allows changes to be animated
        mapLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        layers.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        imgBtn1.setOnClickListener {
            if(BottomSheetBehavior.from(sheet).state != BottomSheetBehavior.STATE_COLLAPSED) {

                BottomSheetBehavior.from(sheet).apply {
                    peekHeight = 0
                    this.state = BottomSheetBehavior.STATE_COLLAPSED
                }

                ObjectAnimator.ofInt(BottomSheetBehavior.from(sheet), "peekHeight", BOTTOMSHEET_HEIGHT).apply {
                    startDelay = 50
                    duration = 300
                    start()
                }
            }
        }

        BottomSheetBehavior.from(sheet).addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        param.bottomMargin = BOTTOMSHEET_HEIGHT
                        webview.layoutParams = param
                    }

                    BottomSheetBehavior.STATE_HIDDEN -> {
                        BottomSheetBehavior.from(sheet).peekHeight = BOTTOMSHEET_HEIGHT
                        param.bottomMargin = 0
                        webview.layoutParams = param
                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if(slideOffset < 0) {
                    param.bottomMargin = rootContainer.height - bottomSheet.top
                    webview.layoutParams = param
                }
            }
        })

        setUpRoutes() // adds elements inside RecyclerView

        zoomIn.setOnClickListener {
            Snackbar.make(rootContainer, "Zoom In", Snackbar.LENGTH_SHORT).show()
        }

        zoomOut.setOnClickListener {
            Snackbar.make(rootContainer, "Zoom Out", Snackbar.LENGTH_SHORT).show()
        }

//        imgBtn2.setOnClickListener {
//            startActivity(Intent(this, SignInActivity::class.java))
//
//            overridePendingTransition(
//                R.anim.slide_in_right,
//                R.anim.slide_out_left
//            )
//        }
    }

    private fun createWebView() {
        webview.webChromeClient = WebChromeClient()
        webview.webViewClient = WebViewClient()
        webview.clearCache(true)
        webview.loadUrl("https://fuckingmap.bss.design/")
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true
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

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
//        for(i in svgId.indices) {
//            val route = Route(svgId[i], description[i], distance[i])
//            newArrayList.add(route)
//        }

        for(i in 1 .. 100) {
            newArrayList.add(Route(R.drawable.ic_round_straight_24, "Descr $i", "dist $i"))
        }

        recyclerView.adapter = RouteAdapter(newArrayList)
    }
}
