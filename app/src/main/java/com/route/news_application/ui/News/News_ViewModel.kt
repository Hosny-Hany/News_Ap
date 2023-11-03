package com.route.news_application.ui.News

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson

import com.route.news_application.Data.Api.model.NewsResponce.News
import com.route.news_application.Data.Api.model.NewsResponce.NewsResponse
import com.route.news_application.repository.SourcesResponse.ScourcesResponse
import com.route.news_application.repository.SourcesResponse.Source
import com.route.news_application.NewsError
import com.route.news_application.Data.Api.model.SourceRpositoty.SourceRepository
import com.route.news_application.repository.SourcesResponse.News.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
@HiltViewModel
class News_ViewModel @Inject constructor(
    private val sourcesRepo : SourceRepository,
    private val NewsRepository : NewsRepository
)  : ViewModel(){
    val shouldShowLoading = MutableLiveData<Boolean>()
    val ResorcesLoading = MutableLiveData<List<Source?>?>()
    val NewsLiveData = MutableLiveData<List<News?>?>()
    val ErrorLiveData = MutableLiveData<NewsError>()

     fun getNewsSources() {
        viewModelScope.launch {
            shouldShowLoading.postValue(true)
            try {
                val sources = sourcesRepo.getsources()
                ResorcesLoading.postValue(sources)
            } catch (e: HttpException) {

                val errorBodyJsonString = e.response()?.errorBody().toString()
                val response = Gson().fromJson(errorBodyJsonString, ScourcesResponse::class.java)

                ErrorLiveData.postValue(NewsError(message = response.message) {
                    getNewsSources()
                })

            } catch (e: Exception) {
                ErrorLiveData.postValue(
                    NewsError(
                        throwable = e
                    ) {
                        getNewsSources()
                    })

            } finally {
                shouldShowLoading.postValue(false)

            }
        }
    }
    fun getNews(id: String?) {
        shouldShowLoading.postValue(true)
        viewModelScope.launch {
            try {
                val articles =  NewsRepository.getNews(SourceId = "")
                NewsLiveData.postValue(articles)
            }
            catch (e:HttpException){
                val ResponseJsonError = e.response()?.errorBody().toString()
                val ErrorResponce = Gson().fromJson(ResponseJsonError, NewsResponse::class.java)
                ErrorLiveData.postValue(NewsError(message = ErrorResponce.message) {
                    getNewsSources()
                })
            }
            catch (e:java.lang.Exception){
                ErrorLiveData.postValue(
                    NewsError(
                        throwable = e
                    ) {
                    getNews(id)
                })
            }
            finally {
                shouldShowLoading.postValue(false)

            }



        }


    }
}

