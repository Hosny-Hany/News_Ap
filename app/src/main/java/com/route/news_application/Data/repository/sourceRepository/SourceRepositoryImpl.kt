package com.route.news_application.Data.repository.sourceRepository

import com.route.news_application.DataSource.SourceDataSource
import com.route.news_application.repository.SourcesResponse.Source
import com.route.news_application.Data.Api.model.SourceRpositoty.SourceRepository
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(private val SourcesOnlineDataSources : SourceDataSource) :
    SourceRepository {
    override suspend fun getsources(): List<Source?>? {
        val sources = SourcesOnlineDataSources.getsource()
        return sources
    }
}