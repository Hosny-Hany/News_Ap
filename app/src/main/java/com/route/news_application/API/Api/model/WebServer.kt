package com.route.news_application.API.Api.model

import com.route.news_application.API.Api.NewsResponce.NewsResponse
import com.route.news_application.API.Api.model.ApiConstants
import com.route.news_application.API.SourcesResponse.ScourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServer {
    @GET("v2/top-headlines/sources")
    fun getsources(
        @Query("apiKey")Key:String = ApiConstants.apikey
    ):Call<ScourcesResponse>
    @GET("v2/everything")
    fun getNews(
        @Query("apiKey")Key:String = ApiConstants.apikey,
        @Query("sources")sources:String
    ):Call<NewsResponse>
}