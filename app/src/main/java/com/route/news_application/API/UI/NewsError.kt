package com.route.news_application.API.UI

import android.os.Message
import com.route.news_application.API.UI.News.NewsFragment

data class NewsError (
    val message: String?=null,
    val throwable: Throwable?=null,
    val onTryAgainClickListener: OnTryAgainClickListener?=null
        )


 fun interface OnTryAgainClickListener{
    fun onTryAgainClick()
 }