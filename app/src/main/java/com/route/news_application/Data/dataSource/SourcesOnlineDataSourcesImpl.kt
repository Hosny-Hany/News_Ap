package com.route.news_application.Data.dataSource

import com.route.news_application.DataSource.SourceDataSource
import com.route.news_application.repository.SourcesResponse.Source
import com.route.news_application.Data.Api.model.WebServer
import javax.inject.Inject

class SourcesOnlineDataSourcesImpl @Inject constructor(private val webServer: WebServer) :
    SourceDataSource {
    override suspend fun getsource(): List<Source?>? {
        val response = webServer.getsources()
        return response.sources
    }
}