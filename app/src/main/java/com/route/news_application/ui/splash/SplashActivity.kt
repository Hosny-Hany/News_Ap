package com.route.news_application.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.news_application.R
import com.route.news_application.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        ,2000
        )
    }
}