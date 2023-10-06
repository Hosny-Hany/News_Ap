package com.route.news_application.API.Api.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        private var retrofit : Retrofit?=null
        private fun getInstance() : Retrofit{
            if (retrofit ==null){
                retrofit =Retrofit.Builder().baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getApi (): WebServer {
            return getInstance().create(WebServer::class.java)
        }

    }

}