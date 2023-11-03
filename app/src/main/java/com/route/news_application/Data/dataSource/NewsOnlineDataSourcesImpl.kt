package com.route.news_application.Data.dataSource

import com.route.news_application.DataSource.NewsDataSource
import com.route.news_application.Data.Api.model.NewsResponce.News
import com.route.news_application.Data.Api.model.WebServer
import javax.inject.Inject

class NewsOnlineDataSourcesImpl @Inject constructor (private val webServer: WebServer):
    NewsDataSource {
    override suspend fun getNews(SourceId: String): List<News?>? {
        val responce = webServer.getNews(sources = SourceId)
        return responce.articles
    }
}