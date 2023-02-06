package com.example.walk_a_mib

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.webkit.WebViewAssetLoader
import com.example.walk_a_mib.adapter.RouteAdapter
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.ui.OtherInfo
import com.example.walk_a_mib.ui.MapsViewModelFactory
import com.example.walk_a_mib.ui.MapsViewModel
import com.example.walk_a_mib.ui.SettingsActivity
import com.example.walk_a_mib.util.ServiceLocator
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.example.walk_a_mib.LocalContentWebViewClient
import com.example.walk_a_mib.logic_layer.domain.NodeType
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.repository.place.IPlaceRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import kotlinx.coroutines.delay
import kotlin.concurrent.timer

// allows us to convert px in dp and vice versa
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

val BOTTOMSHEET_HEIGHT = 65.toPx()

class MainActivity : AppCompatActivity() {

    private lateinit var newArrayList : ArrayList<Route>
    private lateinit var svgId : Array<Int>
    private lateinit var description: Array<String>
    private lateinit var distance: Array<String>

//    private fun darkMode(boolean: Boolean) {
//        when (boolean) {
//            true ->
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//
//            false ->
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = findViewById<CardView>(R.id.settings)
        val sheet = findViewById<LinearLayout>(R.id.sheet)
        val bottomsheetMaterialCardView = findViewById<CardView>(R.id.bottomsheetMaterialCardView)
        val mapLayout = findViewById<LinearLayout>(R.id.mapLayout)
        val param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams
        val rootContainer = findViewById<RelativeLayout>(R.id.rootContainer)
        val poiContainer = findViewById<LinearLayout>(R.id.poi_container)
        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
//        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))
//        val layers = findViewById<ConstraintLayout>(R.id.layers)
        val webview = findViewById<WebView>(R.id.webview)
        createWebView(webview)

        onBackPressedDispatcher.addCallback(this) {
            if (webview.canGoBack()) {
                webview.goBack()
            }
        }

        settings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        val placeRepository = ServiceLocator.getPlaceRepository(this.application)
        val placesNearby = ServiceLocator.getPlacesNearbyRepository(this.application)
        val pathRepository: IPathRepository = ServiceLocator.getPathRepository(this.application)

        val mapsViewModel = ViewModelProvider(
            this,
            MapsViewModelFactory(placeRepository, placesNearby, pathRepository)
        )[MapsViewModel::class.java]

        val infoTitle = findViewById<TextView>(R.id.infoTitle)

        val poiDescription = findViewById<TextView>(R.id.poiDescription)
        val otherInfoContainer = findViewById<LinearLayout>(R.id.otherInfoContainer)

        val observePlace = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlace).placeResponse.place
                Log.d("observer", res.toString())
                val name = res.name
                val descr = res.description
                val ga = res.ga
                val textType = NodeType.getTypeString(res.type);
                //Log.d("cribbio", "insertIcon(\"${res.id}\", \"${res.name}\", [${res.position.lon}, ${res.position.lat}], 24, ${res.ga.floor}, \"${textType}\"))")
                //webview.evaluateJavascript("javascript:insertIcon(\"eheeeh\", \"nome\", [9.221144, 45.523829], 24, 0, \"vending_machine_colddrinks\");", null)
                //webview.evaluateJavascript("javascript:initializeIcons()", null)// adding the name

                infoTitle.text = resources.getString(R.string.poi_info, name)

                // adding the description
                if (descr != "") {
                    poiDescription.text = descr
                } else {
                    poiDescription.text = getString(R.string.missing_poi_description)
                }

                // adding other information
                val otherInfo = OtherInfo(this)

                otherInfo.addOtherInformation(otherInfoContainer, "available", ga.available.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "accessible", ga.accessible.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "indoor", ga.indoor.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "building", ga.building.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "floor", ga.floor.toString())
            } else {
                Snackbar.make(rootContainer, "errore generato da fetchPlace", Snackbar.LENGTH_SHORT).show()
            }
        }

        BottomSheetBehavior.from(sheet).apply {
            this.isHideable = true
            this.state = BottomSheetBehavior.STATE_HIDDEN
            bottomsheetMaterialCardView.layoutParams.height = BOTTOMSHEET_HEIGHT
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

        val observePlacesNearby = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlacesNearby).placesNearbyResponse
                Log.d("MAIN", "ACTUALLY FUCKING WORKS PN! RP = " + res.referencePlace + " --- PN = " + res.placesNearby)

                val places = res.placesNearby

                for(i in places.indices) {
                    layoutInflater.inflate(R.layout.poi, poiContainer)
                    val img = poiContainer.getChildAt(i) as ImageButton

                    when(places[i].place.label) {
                        "door_normal" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.microwave)
                            )
                        }
                        "door_exit" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.indoor)
                            )
                        }
                        "stairs" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.floor)
                            )
                        }
                        "restroom_H" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.warning)
                            )
                        }
                        "restroom_M" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.ic_arrow_right_24)
                            )
                        }
                        "restroom_F" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.outdoor)
                            )
                        }
                        "classroom" -> {
                            img.setImageDrawable(
                                ContextCompat.getDrawable(this, R.drawable.ic_bottom_wave_24)
                            )
                        }
                        else -> {
                            Log.d("manca", places[i].place.label)
                        }
                    }

                    img.setOnClickListener {
                        // clear otherInfoContainer
                        otherInfoContainer.removeAllViews()

                        if(BottomSheetBehavior.from(sheet).state != BottomSheetBehavior.STATE_COLLAPSED) {
                            BottomSheetBehavior.from(sheet).apply {
                                peekHeight = BOTTOMSHEET_HEIGHT
                                this.state = BottomSheetBehavior.STATE_COLLAPSED
                            }
                        }
                        mapsViewModel.fetchPlace((i+1).toString(), 1000)
                            .observe(this, observePlace)
                    }
                }
            }
        }

        mapsViewModel.fetchPlacesNearby("20", 3000, 1000)
            .observe(this, observePlacesNearby)


        setUpRoutes() // adds elements inside RecyclerView

        val zoomIn = findViewById<ImageButton>(R.id.zoomIn)
        zoomIn.setOnClickListener {
            //Snackbar.make(rootContainer, "Zoom In", Snackbar.LENGTH_SHORT).show()
            JSBridge.setFloor(webview, 1)
        }

        val zoomOut = findViewById<ImageButton>(R.id.zoomOut)
        zoomOut.setOnClickListener {
            //Snackbar.make(rootContainer, "Zoom Out", Snackbar.LENGTH_SHORT).show()
            JSBridge.setFloor(webview, 0)
        }
    }

    /*private fun createWebView(webView: WebView) {
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
//        webView.clearCache(true)
        webView.loadUrl("https://fuckingmap.bss.design/")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }*/

    private fun createWebView(webView: WebView){
        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this))
            .addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(this))
            .build()

        webView.webViewClient = LocalContentWebViewClient(assetLoader)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.addJavascriptInterface(JSBridge,"JSBridge")
        webView.loadUrl("https://appassets.androidplatform.net/assets/index.html")

        val instance = this

        val placeRepository: IPlaceRepository =
            ServiceLocator.getPlaceRepository(
                this.application
            )

        val placesNearbyRepository: IPlacesNearbyRepository =
            ServiceLocator.getPlacesNearbyRepository(
                this.application
            )

        val pathRepository: IPathRepository =
            ServiceLocator.getPathRepository(
                this.application
            )

        val mapsViewModel = ViewModelProvider(
            this,
            MapsViewModelFactory(placeRepository, placesNearbyRepository, pathRepository)
        )[MapsViewModel::class.java]

        val allPlacesObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessAllPlaces).allPlaces.places
                JSBridge.showIcons(webView, res);
                Log.d("MAIN", "ACTUALLY FUCKING WORKS ALL PLACES! ${res.toString()}")

            } else {
                Log.d("MAIN", "FUCK NO ALL PLACES")
            }
        }
        val fpObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPath).pathResponse

                JSBridge.showPath(webView, res.nodeList)

                val n = res.nodeList.iterator()
                JSBridge.showUserLocation(webView, n.next().position.lon, n.next().position.lat)
                val timer = object: CountDownTimer(10000, 2000) {

                    override fun onTick(millisUntilFinished: Long) {
                        //if(n.hasNext()){
                        //    JSBridge.updateUserLocation(webView, n.next().position.lon, n.next().position.lat)
                        //}
                        //Log.d("sono un rompicazzo", "certificato!")
                    }

                    override fun onFinish() {
                    }
                }
                timer.start()

                Log.d("MAIN",
                    "ACTUALLY FUCKING WORKS FIND PATH: " + res.pathLength + " --- "
                            + res.nodeList.toString() + " --- " + res.edgeList.toString())


            } else {
                Log.d("MAIN", "FUCK NO FIND PATH")
            }
        }

        val nameObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlace).placeResponse.place.toString()
                Log.d("MAIN", "ACTUALLY FUCKING WORKS " + res)

            } else {
                Log.d("MAIN", "FUCK NO")
            }
        }
        // non mettere id a cazzo
        mapsViewModel.fetchPlace("3", 1000).observe(this, nameObserver)



        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("sono un rompicazzo", "certificato!")
            }

            override fun onFinish() {
                mapsViewModel.fetchAllPlaces(1000).observe(instance, allPlacesObserver)
                mapsViewModel.fetchPath("3", "43", 1000).observe(instance, fpObserver)
            }
        }
        timer.start()

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata(recyclerView)
    }

    private fun getUserdata(recyclerView: RecyclerView) {
//        for(i in svgId.indices) {
//            val route = Route(svgId[i], description[i], distance[i])
//            newArrayList.add(route)
//        }

        for(i in 1 .. 5) {
            newArrayList.add(Route(R.drawable.ic_round_straight_24, "Descr $i", "dist $i"))
        }

        recyclerView.adapter = RouteAdapter(newArrayList)
    }
}



