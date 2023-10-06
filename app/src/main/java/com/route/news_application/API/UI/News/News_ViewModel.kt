package com.route.news_application.API.UI.News

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.route.news_application.API.Api.NewsResponce.News
import com.route.news_application.API.Api.NewsResponce.NewsResponse
import com.route.news_application.API.Api.model.ApiManager
import com.route.news_application.API.SourcesResponse.ScourcesResponse
import com.route.news_application.API.SourcesResponse.Source
import com.route.news_application.API.UI.NewsError
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class News_ViewModel : ViewModel() {
    val shouldShowLoading = MutableLiveData<Boolean>()
    val ResorcesLoading = MutableLiveData<List<Source?>?>()
    val NewsLiveData = MutableLiveData<List<News?>?>()
    val ErrorLiveData = MutableLiveData<NewsError>()
    fun getNewsSources() {
        shouldShowLoading.postValue(true)
        ApiManager
            .getApi()
            .getsources()
            .enqueue(object : Callback<ScourcesResponse> {

                override fun onResponse(
                    call: Call<ScourcesResponse>,
                    response: Response<ScourcesResponse>
                ) {
                    shouldShowLoading.postValue(false)

                    if (response.isSuccessful) {
                        ResorcesLoading.postValue(response.body()?.sources)
                    } else {
                        val errorBodyJsonString = response.errorBody().toString()
                        val response = Gson().fromJson(errorBodyJsonString, ScourcesResponse::class.java)

                        ErrorLiveData.postValue(NewsError(message = response.message){
                            getNewsSources()
                        })
                    }

                }

                override fun onFailure(call: Call<ScourcesResponse>, t: Throwable) {
                    shouldShowLoading.postValue(false)
                    ErrorLiveData.postValue(NewsError(throwable = t){
                       getNewsSources()
                    })
                }
            })
    }

    fun getNews(id: String?) {
        shouldShowLoading.postValue(true)
        ApiManager
            .getApi()
            .getNews(sources = id ?: "")
            .enqueue(object : Callback<NewsResponse> {
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    shouldShowLoading.postValue(false)
                    ErrorLiveData.postValue(NewsError(throwable = t){
                        getNews(id)
                    })

                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    shouldShowLoading.postValue(false)
                    if (response.isSuccessful) {
                        NewsLiveData.postValue(response.body()?.articles)
                        return
                    }
                    val ResponseJsonError = response.errorBody().toString()
                    val ErrorResponce = Gson().fromJson(ResponseJsonError, NewsResponse::class.java)
                    ErrorLiveData.postValue(NewsError(message = ErrorResponce.message){
                        getNewsSources()
                    })

                }
            })

    }
    }
