package com.route.news_application.repository.SourcesResponse.News

import com.route.news_application.Data.Api.model.NewsResponce.News

interface NewsRepository {
    suspend fun getNews(SourceId:String):List<News?>?
}