package com.route.news_application.DataSource

import com.route.news_application.repository.SourcesResponse.Source

interface SourceDataSource {
     suspend fun getsource():List<Source?>?


}