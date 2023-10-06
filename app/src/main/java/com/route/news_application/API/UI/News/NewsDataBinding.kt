package com.route.news_application.API.UI.News

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.MotionPlaceholder
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.net.URL

class NewsDataBinding {
    @BindingAdapter(value = ["app:url" , "app:placeHolder"], requireAll = true)
    fun BindingImageWitheUrl(imageView: ImageView , url: String? , placeHolder: Drawable){

        Glide.with(imageView)
            .load(url)
            .placeholder(placeHolder)
            .into(imageView)

    }
}