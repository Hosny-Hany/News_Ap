package com.route.news_application.API.UI.HOME

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.news_application.API.UI.News.NewsFragment
import com.route.news_application.R
import com.route.news_application.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var ViewBinding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ViewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(ViewBinding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, NewsFragment() )
            .commit()
    }
}