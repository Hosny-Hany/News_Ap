package com.route.news_application.Data.repository.sourceRepository

import com.route.news_application.DataSource.NewsDataSource
import com.route.news_application.repository.SourcesResponse.Source
import com.route.news_application.Data.Api.model.NewsResponce.News
import com.route.news_application.repository.SourcesResponse.News.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val dataSource: NewsDataSource):
    NewsRepository {
    override suspend fun getNews(SourceId: String): List<News?>? {
        return dataSource.getNews(SourceId)
    }
}