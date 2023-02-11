package com.example.walk_a_mib.ui


import android.content.res.Resources
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.webkit.WebViewAssetLoader
import com.example.walk_a_mib.LocalContentWebViewClient
import com.example.walk_a_mib.R
import com.example.walk_a_mib.logic_layer.domain.NodeType
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.repository.place.IPlaceRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.toPx
import com.example.walk_a_mib.util.ServiceLocator
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */



class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val BOTTOMSHEET_HEIGHT = 65.toPx()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<TextView>(R.id.name)
        name.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_navigationFragment)
        }

        val settings = view.findViewById<CardView>(R.id.settings)
        val sheet = view.findViewById<LinearLayout>(R.id.sheet)
        val bottomsheetMaterialCardView = view.findViewById<CardView>(R.id.bottomsheetMaterialCardView)
        val mapLayout = view.findViewById<LinearLayout>(R.id.mapLayout)
        val layerNumber = view.findViewById<TextView>(R.id.layerNumber)
        val param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams
        val rootContainer = view.findViewById<FrameLayout>(R.id.rootContainer)
        val poiContainer = view.findViewById<LinearLayout>(R.id.poi_container)
        val autoCompleteTextView = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val sharedPreferences = this.activity?.getSharedPreferences("save", AppCompatActivity.MODE_PRIVATE)
        val webview = view.findViewById<WebView>(R.id.webview)

//        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))
//        val layers = view.findViewById<ConstraintLayout>(R.id.layers)

        createWebView(webview)

        settings.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_settingsActivity)
        }

        autoCompleteTextView.doOnTextChanged { text, start, before, count ->
            Snackbar.make(poiContainer, "scrivo $text", Snackbar.LENGTH_SHORT).show()
            // TODO(Fare richiesta api basata sul testo scritto qui utilizzando text)
            val temp1 = "${text.toString()} sto completando 1"
            val temp2 = "${text.toString()} sto completando 2"
            val array: Array<String> = arrayOf(temp1, temp2)
            val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, array)
            autoCompleteTextView.setAdapter(adapter)
        }

        BottomSheetBehavior.from(sheet).apply {
            this.isHideable = true
            this.state = BottomSheetBehavior.STATE_HIDDEN
            bottomsheetMaterialCardView.layoutParams.height = BOTTOMSHEET_HEIGHT
//            this.state = BottomSheetBehavior.STATE_COLLAPSED
//            this.peekHeight = BOTTOMSHEET_HEIGHT
//            param.bottomMargin = BOTTOMSHEET_HEIGHT
//            webview.layoutParams = param
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

//        onBackPressedDispatcher.addCallback(this) {
//            if (webview.canGoBack()) {
//                webview.goBack()
//            }
//        }

        val placeRepository = ServiceLocator.getPlaceRepository(requireActivity().application)
        val placesNearby = ServiceLocator.getPlacesNearbyRepository(requireActivity().application)
        val pathRepository: IPathRepository = ServiceLocator.getPathRepository(requireActivity().application)

        val mapsViewModel = ViewModelProvider(
            this,
            MapsViewModelFactory(placeRepository, placesNearby, pathRepository)
        )[MapsViewModel::class.java]

        val infoTitle = view.findViewById<TextView>(R.id.infoTitle)

        val poiDescription = view.findViewById<TextView>(R.id.poiDescription)
        val otherInfoContainer = view.findViewById<LinearLayout>(R.id.otherInfoContainer)

        val observePlace = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPlace).placeResponse.place
                Log.d("observer", res.toString())
                val poiName = res.name
                val poiDescr = res.description
                val ga = res.ga
                val textType = NodeType.getTypeString(res.type);
                //Log.d("cribbio", "insertIcon(\"${res.id}\", \"${res.name}\", [${res.position.lon}, ${res.position.lat}], 24, ${res.ga.floor}, \"${textType}\"))")
                //webview.evaluateJavascript("javascript:insertIcon(\"eheeeh\", \"nome\", [9.221144, 45.523829], 24, 0, \"vending_machine_colddrinks\");", null)
                //webview.evaluateJavascript("javascript:initializeIcons()", null)// adding the name

                infoTitle.text = resources.getString(R.string.poi_info, poiName)

                // adding the description
                if (poiDescr != "") {
                    poiDescription.text = poiDescr
                } else {
                    poiDescription.text = getString(R.string.missing_poi_description)
                }

                // adding other information
                val otherInfo = OtherInfo(requireContext())

                otherInfo.addOtherInformation(otherInfoContainer, "available", ga.available.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "accessible", ga.accessible.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "indoor", ga.indoor.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "building", ga.building.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "floor", ga.floor.toString())
            }
        }

        mapsViewModel.fetchPlace("idSelezionato", 1000).observe(requireActivity(), observePlace)

        val horizontalScrollView = view.findViewById<HorizontalScrollView>(R.id.horizontalScrollView)

        val observePlacesNearby = Observer<CallResult> { result ->
            val isFirstElementArrayList = arrayListOf(true, true, true, true, true, true, true, true, true)
            val imgMap = mutableMapOf<String, ImageButton>()

            if (result.isSuccess() && horizontalScrollView.childCount == 1) {
                val res = (result as CallResult.SuccessPlacesNearby).placesNearbyResponse
                Log.d("POIs", "ACTUALLY FUCKING WORKS PN! RP = " + res.referencePlace + " --- PN = " + res.placesNearby)

                val places = res.placesNearby

                val filterHandler = FilterHandler(requireContext(), places, poiContainer, webview)

                filterHandler.handlePlace()

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
//                                    requireContext(), poiContainer, R.drawable.ic_door_open_solid
//                                )
//                                imgMap["door_normal"] = img
//                                isFirstElementArrayList[0] = false
//                            }
//                        }
//                        "door_exit" -> {
//                            if(isFirstElementArrayList[1]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_person_walking_arrow_right_solid
//                                )
//                                imgMap["door_exit"] = img
//                                isFirstElementArrayList[1] = false
//                            }
//                        }
//                        "stairs" -> {
//                            if(isFirstElementArrayList[2]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_stairs
//                                )
//                                imgMap["stairs"] = img
//                                isFirstElementArrayList[2] = false
//                            }
//                        }
//                        "restroom_H" -> {
//                            if(isFirstElementArrayList[3]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_accessible_icon
//                                )
//                                imgMap["restroom_H"] = img
//                                isFirstElementArrayList[3] = false
//                            }
//                        }
//                        "restroom_M" -> {
//                            if(isFirstElementArrayList[4]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_person
//                                )
//                                imgMap["restroom_M"] = img
//                                isFirstElementArrayList[4] = false
//                            }
//                        }
//                        "restroom_F" -> {
//                            if(isFirstElementArrayList[5]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_person_dress
//                                )
//                                imgMap["restroom_F"] = img
//                                isFirstElementArrayList[5] = false
//                            }
//                        }
//                        "classroom" -> {
//                            if(isFirstElementArrayList[6]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_chalkboard_user
//                                )
//                                imgMap["classroom"] = img
//                                isFirstElementArrayList[6] = false
//                            }
//                        }
//                        "vending_machine_hotdrinks" -> {
//                            if(isFirstElementArrayList[7]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_mug_hot
//                                )
//                                imgMap["vending_machine_hotdrinks"] = img
//                                isFirstElementArrayList[7] = false
//                            }
//                        }
//                        "vending_machine_colddrinks" -> {
//                            if (isFirstElementArrayList[8]) {
//                                val img = Utility.inflateAndAddIcon(
//                                    requireContext(), poiContainer, R.drawable.ic_bottle_water
//                                )
//                                imgMap["vending_machine_colddrinks"] = img
//                                isFirstElementArrayList[8] = false
//                            }
//                        }
//                        else -> {
//                            Log.d("manca", places[i].place.label)
//                        }
//                    }
//
//                    var imgAlreadyClicked = false
//                    var type: String? = null
//                    imgMap.forEach { entry ->
//                        entry.value.setOnClickListener {
//                            if(imgAlreadyClicked && type != null) {
//                                val element = imgMap[type] // get the last clicked element before this
//                                Utility.changeBgColorAndColor(requireContext(), element!!, R.color.backgroundColorPoI, R.color.colorPoI) // reset old filter color
//                                JSBridge.resetFilters(webview) // reset old map filter
//                                if(entry.key != type) { // clicked different filter
//                                    JSBridge.filterByType(webview, entry.key)
//                                    Utility.changeBgColorAndColor(requireContext(), entry.value, R.color.colorPoI, R.color.backgroundColorPoI)
//                                } else {
//                                    imgAlreadyClicked = false
//                                }
//                            } else {
//                                JSBridge.filterByType(webview, entry.key)
//                                imgAlreadyClicked = true
//                                Utility.changeBgColorAndColor(requireContext(), entry.value, R.color.colorPoI, R.color.backgroundColorPoI)
//                            }
//                            type = entry.key
//                        }
//                    }
//
//                    i++
//                } while(stop && i < places.size)
            }
        }

        mapsViewModel.fetchPlacesNearby("20", 3000, 1000)
            .observe(requireActivity(), observePlacesNearby)

        var floor = 0
        layerNumber.text = "T"

        val zoomIn = view.findViewById<ImageButton>(R.id.zoomIn)
        zoomIn.setOnClickListener {
            if(floor < 1) {
                floor++
                layerNumber.text = floor.toString()
                JSBridge.setFloor(webview, floor)
            }
        }

        val zoomOut = view.findViewById<ImageButton>(R.id.zoomOut)
        zoomOut.setOnClickListener {
            if(floor > 0) {
                floor--
                if(floor == 0) {
                    layerNumber.text = "T"
                } else {
                    layerNumber.text = floor.toString()
                }
                JSBridge.setFloor(webview, floor)
            }
        }



    }

    private fun createWebView(webView: WebView){
        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireActivity().application))
            .addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(requireActivity().application))
            .build()

        webView.webViewClient = LocalContentWebViewClient(assetLoader)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.addJavascriptInterface(JSBridge,"JSBridge")
        webView.loadUrl("https://appassets.androidplatform.net/assets/index.html")

        val placeRepository: IPlaceRepository =
            ServiceLocator.getPlaceRepository(
                requireActivity().application
            )

        val placesNearbyRepository: IPlacesNearbyRepository =
            ServiceLocator.getPlacesNearbyRepository(
                requireActivity().application
            )

        val pathRepository: IPathRepository =
            ServiceLocator.getPathRepository(
                requireActivity().application
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

        mapsViewModel.fetchAllPlaces(1000).observe(requireActivity(), allPlacesObserver)

        val fpObserver = Observer<CallResult> { result ->
            if (result.isSuccess()) {
                val res = (result as CallResult.SuccessPath).pathResponse

//                JSBridge.showPath(webView, res.nodeList)

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
        mapsViewModel.fetchPlace("3", 1000).observe(requireActivity(), nameObserver)



        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("sono un rompicazzo", "certificato!")
            }

            override fun onFinish() {
                mapsViewModel.fetchAllPlaces(1000).observe(requireActivity(), allPlacesObserver)
                mapsViewModel.fetchPath("3", "30", 1000).observe(requireActivity(), fpObserver)
            }
        }
        timer.start()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}