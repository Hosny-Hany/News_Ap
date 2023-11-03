package com.route.news_application

data class NewsError (
    val message: String?=null,
    val throwable: Throwable?=null,
    val onTryAgainClickListener: OnTryAgainClickListener?=null
        )


 fun interface OnTryAgainClickListener{
    fun onTryAgainClick()
 }