package com.example.walk_a_mib.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.walk_a_mib.R

class SignInActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_signin)

        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
        darkMode(sharedPreferences.getBoolean("darkModeSwitch", false))
//        val webViewSignIn = findViewById<WebView>(R.id.webViewSignIn)
//        createWebView(webViewSignIn)
    }

//    private fun createWebView(webViewSignIn: WebView) {
//        webViewSignIn.webChromeClient = WebChromeClient()
//        webViewSignIn.webViewClient = WebViewClient()
//        webViewSignIn.clearCache(true)
//        webViewSignIn.loadUrl("https://login.microsoftonline.com/organizations/oauth2/v2.0/authorize?redirect_uri=https%3A%2F%2Fportal.azure.com%2Fsignin%2Findex%2F&response_type=code%20id_token&scope=https%3A%2F%2Fmanagement.core.windows.net%2F%2Fuser_impersonation%20openid%20email%20profile&state=OpenIdConnect.AuthenticationProperties%3DVm_rNGsOgFmG_0de-qkdN2CNtz6sjnVrR8-9ZwpM_kfH2D4RtacovPz2d-yFmX6Uxa8IQEZFZwc3pjqKLxvfyM5-vIn8y3EmAwBJVsDdbuHj2rcm93YHZLOzProR9lqAbFRPOYopo0BBariUfQq5CfKHVZEhQH5p46vU8zlay1rYiicP4kjJHKGNBVMJtTU53QL8dOeunXV70RiKvx3I0ahq5oXS2shojgG7GxifFrOwslfXEIvJ-Islh_jY78-q4Ro01GEPKo7hxB3v8Fq851bS6GHfahlE2vZSHFf3jF4MSu7bRp8byoL4Ni9Y2VrlgFhvaR3InHV4nMgKkePL06jcCabrzCYATYcM8diBCB1lGQlUULVmdZTtHON5nic0gadsE4kgufq_AuVRKLoS6c_ThBL2Q0sPvfaRy4tv_oXBXRBQ1MRr5BONKnX4KZefRvHdFGogT4OBKkd-u9rk_Uh8texUY0GbbrMJNzQnYKY&response_mode=form_post&nonce=638087321229673471.N2M0YTQ5ZGQtOWY1My00NDRmLWJiYzMtODYxYzkxNDc3N2JkMjhkZTE0MjMtYTVkOC00MmZjLWIwMmItYzY5ZWI4MTc0ZGE3&client_id=c44b4083-3bb0-49c1-b47d-974e53cbdf3c&site_id=501430&client-request-id=66e00d59-c40f-4460-95b9-8d8d475bc1b3&x-client-SKU=ID_NET472&x-client-ver=6.22.1.0")
//        val webSettings = webViewSignIn.settings
//        webSettings.javaScriptEnabled = true
//
//        val skip = findViewById<Button>(R.id.skip)
//        skip.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
////            overridePendingTransition(
////                R.anim.slide_in_right,
////                R.anim.slide_out_left
////            )
//        }

//    }

    override fun finish() {
        super.finish()

//        overridePendingTransition(
//            R.anim.slide_in_right,
//            R.anim.slide_out_left
//        )
    }
}