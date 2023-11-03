package com.route.news_application.ui.News

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class NewsDataBinding {
    @BindingAdapter(value = ["app:url" , "app:placeHolder"], requireAll = true)
    fun BindingImageWitheUrl(imageView: ImageView , url: String? , placeHolder: Drawable){

        Glide.with(imageView)
            .load(url)
            .placeholder(placeHolder)
            .into(imageView)

    }
}