package com.route.news_application

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("BackgroundColor")
fun changeCardViewBackground(cardView: CardView , color: Int){
    cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,color))
}
@BindingAdapter("image")
fun loudImageId( imageView: ImageView , image: Int ){
    imageView.setImageResource(image)
}