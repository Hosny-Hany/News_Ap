package com.route.news_application.ui.News

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
class di {
     @Provides
    fun provideNewsAdapter(): News_Adapter {
        return News_Adapter(listOf())
    }
}