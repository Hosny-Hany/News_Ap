package com.route.news_application.Data.Api.model

import com.route.news_application.Data.Api.model.NewsResponce.NewsResponse
import com.route.news_application.Data.Api.model.ApiConstants
import com.route.news_application.repository.SourcesResponse.ScourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServer {
    @GET("v2/top-headlines/sources")
   suspend fun getsources(
        @Query("apiKey")Key:String = ApiConstants.apikey
    ): ScourcesResponse
    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey")Key:String = ApiConstants.apikey,
        @Query("sources")sources:String
    ): NewsResponse
}