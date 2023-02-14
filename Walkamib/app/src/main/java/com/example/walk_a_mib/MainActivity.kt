package com.example.walk_a_mib

import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.webkit.WebViewAssetLoader
import com.example.walk_a_mib.adapter.RouteAdapter
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.util.ServiceLocator
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.repository.node.INodeRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.ui.*

// allows us to convert px in dp and vice versa
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

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

//        val settings = findViewById<CardView>(R.id.settings)
//        val sheet = findViewById<LinearLayout>(R.id.sheet)
//        val bottomsheetMaterialCardView = findViewById<CardView>(R.id.bottomsheetMaterialCardView)
//        val mapLayout = findViewById<LinearLayout>(R.id.mapLayout)
//        val layerNumber = findViewById<TextView>(R.id.layerNumber)
//        val param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams
//        val rootContainer = findViewById<RelativeLayout>(R.id.rootContainer)
//        val poiContainer = findViewById<LinearLayout>(R.id.poi_container)
//        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
////        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))
////        val layers = findViewById<ConstraintLayout>(R.id.layers)
//        val webview = findViewById<WebView>(R.id.webview)
//        createWebView(webview)
//
//
//        onBackPressedDispatcher.addCallback(this) {
//            if (webview.canGoBack()) {
//                webview.goBack()
//            }
//        }
//
//        settings.setOnClickListener {
//            startActivity(Intent(this, SettingsActivity::class.java))
//        }
//
//        val placeRepository = ServiceLocator.getPlaceRepository(this.application)
//        val placesNearby = ServiceLocator.getPlacesNearbyRepository(this.application)
//        val pathRepository: IPathRepository = ServiceLocator.getPathRepository(this.application)
//
//        val mapsViewModel = ViewModelProvider(
//            this,
//            MapsViewModelFactory(placeRepository, placesNearby, pathRepository)
//        )[MapsViewModel::class.java]
//
//        val infoTitle = findViewById<TextView>(R.id.infoTitle)
//
//        val poiDescription = findViewById<TextView>(R.id.poiDescription)
//        val otherInfoContainer = findViewById<LinearLayout>(R.id.otherInfoContainer)
//
//        val observePlace = Observer<CallResult> { result ->
//            if (result.isSuccess()) {
//                val res = (result as CallResult.SuccessPlace).placeResponse.place
//                Log.d("observer", res.toString())
//                val name = res.name
//                val descr = res.description
//                val ga = res.ga
//                val textType = NodeType.getTypeString(res.type);
//                //Log.d("cribbio", "insertIcon(\"${res.id}\", \"${res.name}\", [${res.position.lon}, ${res.position.lat}], 24, ${res.ga.floor}, \"${textType}\"))")
//                //webview.evaluateJavascript("javascript:insertIcon(\"eheeeh\", \"nome\", [9.221144, 45.523829], 24, 0, \"vending_machine_colddrinks\");", null)
//                //webview.evaluateJavascript("javascript:initializeIcons()", null)// adding the name
//
//                infoTitle.text = resources.getString(R.string.poi_info, name)
//
//                // adding the description
//                if (descr != "") {
//                    poiDescription.text = descr
//                } else {
//                    poiDescription.text = getString(R.string.missing_poi_description)
//                }
//
//                // adding other information
//                val otherInfo = OtherInfo(this)
//
//                otherInfo.addOtherInformation(otherInfoContainer, "available", ga.available.toString())
//                otherInfo.addOtherInformation(otherInfoContainer, "accessible", ga.accessible.toString())
//                otherInfo.addOtherInformation(otherInfoContainer, "indoor", ga.indoor.toString())
//                otherInfo.addOtherInformation(otherInfoContainer, "building", ga.building.toString())
//                otherInfo.addOtherInformation(otherInfoContainer, "floor", ga.floor.toString())
//            }
//        }
//
//        BottomSheetBehavior.from(sheet).apply {
//            this.isHideable = true
////            this.state = BottomSheetBehavior.STATE_HIDDEN
////            bottomsheetMaterialCardView.layoutParams.height = BOTTOMSHEET_HEIGHT
//            this.state = BottomSheetBehavior.STATE_COLLAPSED
//            this.peekHeight = BOTTOMSHEET_HEIGHT
//            param.bottomMargin = BOTTOMSHEET_HEIGHT
//            webview.layoutParams = param
//        }
//
//
//        BottomSheetBehavior.from(sheet).addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when(newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> {
//                        param.bottomMargin = BOTTOMSHEET_HEIGHT
//                        webview.layoutParams = param
//                    }
//
//                    BottomSheetBehavior.STATE_HIDDEN -> {
//                        BottomSheetBehavior.from(sheet).peekHeight = BOTTOMSHEET_HEIGHT
//                        param.bottomMargin = 0
//                        webview.layoutParams = param
//                    }
//                }
//            }
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                if(slideOffset < 0) {
//                    param.bottomMargin = rootContainer.height - bottomSheet.top
//                    webview.layoutParams = param
//                }
//            }
//        })
//
//
//        val observePlacesNearby = Observer<CallResult> { result ->
//            val isFirstElementArrayList = arrayListOf(true, true, true, true, true, true, true, true, true)
//            val imgMap = mutableMapOf<String, ImageButton>()
//
//            if (result.isSuccess()) {
//                val res = (result as CallResult.SuccessPlacesNearby).placesNearbyResponse
//                Log.d("MAIN", "ACTUALLY FUCKING WORKS PN! RP = " + res.referencePlace + " --- PN = " + res.placesNearby)
//
//                val places = res.placesNearby
//                var i = 0
//
//                do {
//                    var stop = false
//                    var pos = 0 // used to cycle over isFirstElementArrayList
//
//                    while(!stop && pos < isFirstElementArrayList.size) {
//                        if(isFirstElementArrayList[pos]) {
//                            stop = true
//                        }
//                        pos++
//                    }
//
//                    when(places[i].place.label) {
//                        "door_normal" -> {
//                            if(isFirstElementArrayList[0]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_door_open_solid
//                                )
//                                imgMap["door_normal"] = img
////                                img.setOnClickListener {
////                                    isClicked[0] = Utility.toggleClick(this, webview, isClicked[0], "door_normal", img)
////                                }
//                                isFirstElementArrayList[0] = false
//                            }
//                        }
//                        "door_exit" -> {
//                            if(isFirstElementArrayList[1]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_person_walking_arrow_right_solid
//                                )
//                                imgMap["door_exit"] = img
////                                img.setOnClickListener {
////                                    isClicked[1] = Utility.toggleClick(this, webview, isClicked[1], "door_exit", img)
////                                }
//                                isFirstElementArrayList[1] = false
//                            }
//                        }
//                        "stairs" -> {
//                            if(isFirstElementArrayList[2]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_stairs
//                                )
//                                imgMap["stairs"] = img
////                                img.setOnClickListener {
////                                    isClicked[2] = Utility.toggleClick(this, webview, isClicked[2], "stairs", img)
////                                }
//                                isFirstElementArrayList[2] = false
//                            }
//                        }
//                        "restroom_H" -> {
//                            if(isFirstElementArrayList[3]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_accessible_icon
//                                )
//                                imgMap["restroom_H"] = img
////                                img.setOnClickListener {
////                                    isClicked[3] = Utility.toggleClick(this, webview, isClicked[3], "restroom_H", img)
////                                }
//                                isFirstElementArrayList[3] = false
//                            }
//                        }
//                        "restroom_M" -> {
//                            if(isFirstElementArrayList[4]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_person
//                                )
//                                imgMap["restroom_M"] = img
////                                img.setOnClickListener {
////                                    isClicked[4] = Utility.toggleClick(this, webview, isClicked[4], "restroom_M", img)
////                                }
//                                isFirstElementArrayList[4] = false
//                            }
//                        }
//                        "restroom_F" -> {
//                            if(isFirstElementArrayList[5]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_person_dress
//                                )
//                                imgMap["restroom_F"] = img
////                                img.setOnClickListener {
////                                    isClicked[5] = Utility.toggleClick(this, webview, isClicked[5], "restroom_F", img)
////                                }
//                                isFirstElementArrayList[5] = false
//                            }
//                        }
//                        "classroom" -> {
//                            if(isFirstElementArrayList[6]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_chalkboard_user
//                                )
//                                imgMap["classroom"] = img
////                                img.setOnClickListener {
////                                    isClicked[6] = Utility.toggleClick(this, webview, isClicked[6], "classroom", img)
////                                }
//                                isFirstElementArrayList[6] = false
//                            }
//                        }
//
//                        "vending_machine_hotdrinks" -> {
//                            if(isFirstElementArrayList[7]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_mug_hot
//                                )
//                                imgMap["vending_machine_hotdrinks"] = img
////                                img.setOnClickListener {
////                                    isClicked[7] = Utility.toggleClick(this, webview, isClicked[7], "vending_machine_hotdrinks", img)
////                                }
//                                isFirstElementArrayList[7] = false
//                            }
//                        }
//
//                        "vending_machine_colddrinks" -> {
//                            if (isFirstElementArrayList[8]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    this, poiContainer, R.drawable.ic_bottle_water
//                                )
//                                imgMap["vending_machine_colddrinks"] = img
////                                img.setOnClickListener {
////                                    isClicked[8] = Utility.toggleClick(this, webview, isClicked[8], "vending_machine_colddrinks", img)
////                                }
//                                isFirstElementArrayList[8] = false
//                            }
//                        }
//                        else -> {
//                            Log.d("manca", places[i].place.label)
//                        }
//                    }
//
////                    imgMap.forEachIndexed { index, element ->
////                        element.setOnClickListener {
////                            isClicked[index] = Utility.toggleClick(this, webview, isClicked[index], , element)
////                        }
////                    }
//
//                    var imgAlreadyClicked = false
//                    var type: String? = null
//                    imgMap.forEach { entry ->
//                        entry.value.setOnClickListener {
//                            if(imgAlreadyClicked && type != null) {
//                                val element = imgMap[type] // get the last clicked element before this
//                                Utility.changeBgColorAndColor(this, element!!, R.color.backgroundColorPoI, R.color.colorPoI) // reset old filter color
//                                JSBridge.resetFilters(webview) // reset old map filter
//                                if(entry.key != type) { // clicked different filter
//                                    JSBridge.filterByType(webview, entry.key)
//                                    Utility.changeBgColorAndColor(this, entry.value, R.color.colorPrimaryDark, R.color.backgroundColorPoI)
//                                } else {
//                                    imgAlreadyClicked = false
//                                }
//                            } else {
//                                JSBridge.filterByType(webview, entry.key)
//                                imgAlreadyClicked = true
//                                Utility.changeBgColorAndColor(this, entry.value, R.color.colorPrimaryDark, R.color.backgroundColorPoI)
//                            }
//                            type = entry.key
//                        }
//                    }
//
//                    i++
//                } while(stop && i < places.size)
//            }
//        }
//
//        mapsViewModel.fetchPlacesNearby("20", 3000, 1000)
//            .observe(this, observePlacesNearby)
//
//
//        setUpRoutes() // adds elements inside RecyclerView
//
//        var floor = 0
//        layerNumber.text = "T"
//
//        val zoomIn = findViewById<ImageButton>(R.id.zoomIn)
//        zoomIn.setOnClickListener {
//            if(floor < 1) {
//                floor++
//                layerNumber.text = floor.toString()
//                JSBridge.setFloor(webview, floor)
//            }
//        }
//
//        val zoomOut = findViewById<ImageButton>(R.id.zoomOut)
//        zoomOut.setOnClickListener {
//            if(floor > 0) {
//                floor--
//                if(floor == 0) {
//                    layerNumber.text = "T"
//                } else {
//                    layerNumber.text = floor.toString()
//                }
//                JSBridge.setFloor(webview, floor)
//            }
//        }
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

        val placeRepository: INodeRepository =
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
                val res = (result as CallResult.SuccessAllPlaces).allPlaces.nodes
                JSBridge.showIcons(webView, res);
                Log.d("MAIN", "ACTUALLY FUCKING WORKS ALL PLACES! ${res.toString()}")

            } else {
                Log.d("MAIN", "FUCK NO ALL PLACES")
            }
        }

        mapsViewModel.fetchAllPlaces(1000).observe(instance, allPlacesObserver)

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



        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("sono un rompicazzo", "certificato!")
            }

            override fun onFinish() {
                mapsViewModel.fetchAllPlaces(1000).observe(instance, allPlacesObserver)
                mapsViewModel.fetchPath("3", "30", true, 1000).observe(instance, fpObserver)
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



