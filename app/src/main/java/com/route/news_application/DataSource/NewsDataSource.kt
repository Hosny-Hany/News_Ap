package com.route.news_application.DataSource

import com.route.news_application.Data.Api.model.NewsResponce.News

interface NewsDataSource {
    suspend fun getNews(SourceId:String):List<News?>?
    }
