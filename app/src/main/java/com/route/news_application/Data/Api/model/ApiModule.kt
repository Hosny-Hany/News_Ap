package com.route.news_application.Data.Api.model

import android.app.Activity
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ActivityComponent::class)
@Module
object ApiModule {
    @Provides
    fun provideLogginInterceptor():HttpLoggingInterceptor{
        val LoggingInterceptor=  HttpLoggingInterceptor {
            Log.e("Api",it)
        }

        LoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return LoggingInterceptor
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofiy (okHttpClient: OkHttpClient ,
                         gsonConverterFactory: GsonConverterFactory):Retrofit{
        var retrofit = Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .baseUrl("https://newsapi.org/")
            .build()
        return retrofit
    }

    @Provides
    fun getWebServies(retrofit: Retrofit):WebServer{

        return retrofit.create(WebServer::class.java)
    }
}