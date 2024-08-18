package com.monotoshghosh.flappybird

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)
        webviewShow(webView)

        window.apply {
            // SET THE STATUS BAR COLOR TO WHITE
            statusBarColor = ContextCompat.getColor(this@MainActivity, android.R.color.black)

            // SET THE STATUS BAR ICONS TO BE DARK
            decorView.systemUiVisibility = 0
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewShow(a:WebView){ // Fun Definition
        a.webViewClient= WebViewClient()

        a.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            loadUrl("https://flappybird.io/")
        }
    }

}