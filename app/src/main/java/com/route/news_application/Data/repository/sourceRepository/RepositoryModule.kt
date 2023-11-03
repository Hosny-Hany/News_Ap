package com.route.news_application.Data.repository.sourceRepository

import com.route.news_application.DataSource.NewsDataSource
import com.route.news_application.DataSource.SourceDataSource
import com.route.news_application.Data.Api.model.SourceRpositoty.SourceRepository
import com.route.news_application.Data.dataSource.NewsOnlineDataSourcesImpl
import com.route.news_application.Data.dataSource.SourcesOnlineDataSourcesImpl
import com.route.news_application.repository.SourcesResponse.News.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule  {

    @Binds
    abstract fun provideSourceRepository(repo:SourceRepositoryImpl): SourceRepository

    @Binds
    abstract fun provideNewsRepository(repo:NewsRepositoryImpl): NewsRepository

    @Binds
    abstract fun provideSourceDataSource(dataSource: SourcesOnlineDataSourcesImpl): SourceDataSource

    @Binds
    abstract fun provideNewsDataSource(dataSource: NewsOnlineDataSourcesImpl): NewsDataSource


}