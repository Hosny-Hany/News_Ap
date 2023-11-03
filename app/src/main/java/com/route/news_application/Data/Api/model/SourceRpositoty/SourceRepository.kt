package com.route.news_application.Data.Api.model.SourceRpositoty

import com.route.news_application.repository.SourcesResponse.Source

interface SourceRepository {
    suspend fun getsources():List<Source?>?
}