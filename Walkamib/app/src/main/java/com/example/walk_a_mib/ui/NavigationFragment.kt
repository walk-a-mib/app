package com.example.walk_a_mib.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.webkit.WebViewAssetLoader
import com.example.walk_a_mib.LocalContentWebViewClient
import com.example.walk_a_mib.R
import com.example.walk_a_mib.Route
import com.example.walk_a_mib.logic_layer.domain.NodeType
import com.example.walk_a_mib.model.CallResult
import com.example.walk_a_mib.model.JSBridge
import com.example.walk_a_mib.repository.path.IPathRepository
import com.example.walk_a_mib.repository.node.INodeRepository
import com.example.walk_a_mib.repository.placesNearby.IPlacesNearbyRepository
import com.example.walk_a_mib.toPx
import com.example.walk_a_mib.util.ServiceLocator
import com.google.android.material.bottomsheet.BottomSheetBehavior

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

//// allows us to convert px in dp and vice versa
//fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
//fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()


class NavigationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var newArrayList : ArrayList<Route>
    private lateinit var svgId : Array<Int>
    private lateinit var description: Array<String>
    private lateinit var distance: Array<String>

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
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settings = view.findViewById<CardView>(R.id.settings)
        val sheet = view.findViewById<LinearLayout>(R.id.sheet)
        val bottomsheetMaterialCardView = view.findViewById<CardView>(R.id.bottomsheetMaterialCardView)
        val mapLayout = view.findViewById<LinearLayout>(R.id.mapLayout)
        val layerNumber = view.findViewById<TextView>(R.id.layerNumber)
        val param = mapLayout.layoutParams as ViewGroup.MarginLayoutParams
        val rootContainer = view.findViewById<FrameLayout>(R.id.rootContainer)
        val poiContainer = view.findViewById<LinearLayout>(R.id.poi_container)
        val exitNavigationMode = view.findViewById<ImageButton>(R.id.exitNavigationMode)
        val sharedPreferences = this.activity?.getSharedPreferences("save", AppCompatActivity.MODE_PRIVATE)
//        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))
//        val layers = view.findViewById<ConstraintLayout>(R.id.layers)
        val webview = view.findViewById<WebView>(R.id.webview)
        createWebView(webview)


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

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_navigationFragment_to_mainFragment)
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

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
                val otherInfo = OtherInfo(requireContext())

                otherInfo.addOtherInformation(otherInfoContainer, "available", ga.available.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "accessible", ga.accessible.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "indoor", ga.indoor.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "building", ga.building.toString())
                otherInfo.addOtherInformation(otherInfoContainer, "floor", ga.floor.toString())
            }
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


//        val observePlacesNearby = Observer<CallResult> { result ->
//            val isFirstElementArrayList = arrayListOf(true, true, true, true, true, true, true, true, true)
//            val imgMap = mutableMapOf<String, ImageButton>()
//
//            if (result.isSuccess()) {
//                val res = (result as CallResult.SuccessPlacesNearby).placesNearbyResponse
//                Log.d("MAIN", "ACTUALLY FUCKING WORKS PN! RP = " + res.referencePlace + " --- PN = " + res.placesNearby)
//
//                val places = res.placesNearby
//
//                val filterHandler = FilterHandler(requireContext(), places, poiContainer, webview)
//                filterHandler.handlePlace()
//            }
//        }

//        mapsViewModel.fetchPlacesNearby("20", 3000, 1000)
//            .observe(requireActivity(), observePlacesNearby)


        val zoomIn = view.findViewById<ImageButton>(R.id.zoomIn)
        val zoomOut = view.findViewById<ImageButton>(R.id.zoomOut)

        var floor = 0
        layerNumber.text = "T"
        DrawableCompat.setTint(
            DrawableCompat.wrap(zoomOut.drawable),
            ContextCompat.getColor(requireContext(), R.color.zoomArrowDeactivated)
        )
        DrawableCompat.setTint(
            DrawableCompat.wrap(zoomIn.drawable),
            ContextCompat.getColor(requireContext(), R.color.zoomArrowAndText)
        )

        zoomIn.setOnClickListener {
            if(floor < 1) {
                floor++
                layerNumber.text = floor.toString()
                JSBridge.setFloor(webview, floor)
                DrawableCompat.setTint(
                    DrawableCompat.wrap(zoomIn.drawable),
                    ContextCompat.getColor(requireContext(), R.color.zoomArrowDeactivated)
                )
                DrawableCompat.setTint(
                    DrawableCompat.wrap(zoomOut.drawable),
                    ContextCompat.getColor(requireContext(), R.color.zoomArrowAndText)
                )
            }
        }

        zoomOut.setOnClickListener {
            if(floor > 0) {
                floor--
                if(floor == 0) {
                    layerNumber.text = "T"
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(zoomOut.drawable),
                        ContextCompat.getColor(requireContext(), R.color.zoomArrowDeactivated)
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(zoomIn.drawable),
                        ContextCompat.getColor(requireContext(), R.color.zoomArrowAndText)
                    )
                } else {
                    layerNumber.text = floor.toString()
                }
                JSBridge.setFloor(webview, floor)
            }
        }

        exitNavigationMode.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_navigationFragment_to_mainFragment)
        }


//        // onPageFinished
//        webview.webViewClient = object : WebViewClient() {
//            override fun onPageFinished(webView: WebView, url: String) {
//                Snackbar.make(rootContainer, "onpagefinished", Snackbar.LENGTH_SHORT).show()
//
//                val allPlacesObserver = Observer<CallResult> { result ->
//                    if (result.isSuccess()) {
//                        val res = (result as CallResult.SuccessAllPlaces).allPlaces.places
//                        JSBridge.showIcons(webView, res)
//                        JSBridge.showIcons(webView, res)
//                        Log.d("MAIN", "ACTUALLY FUCKING WORKS ALL PLACES! ${res.toString()}")
//
//                    } else {
//                        Log.d("MAIN", "FUCK NO ALL PLACES")
//                    }
//                }
//
//                mapsViewModel.fetchAllPlaces(1000).observe(requireActivity(), allPlacesObserver)
//            }
//        }
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

        val placeRepository: INodeRepository =
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
                val res = (result as CallResult.SuccessAllNodes).allNodes.nodes
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
        mapsViewModel.fetchPlace("3", 1000).observe(requireActivity(), nameObserver)



        val timer = object: CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("sono un rompicazzo", "certificato!")
            }

            override fun onFinish() {
                mapsViewModel.fetchAllPlaces(1000).observe(requireActivity(), allPlacesObserver)
                mapsViewModel.fetchPath("3", "30", false, 1000).observe(requireActivity(), fpObserver)
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
         * @return A new instance of fragment NavigationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavigationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}