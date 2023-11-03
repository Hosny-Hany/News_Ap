package com.route.news_application.ui.News

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.news_application.Data.Api.model.NewsResponce.News
import com.route.news_application.databinding.ItemNewsBinding

class News_Adapter (var newList : List<News?>?=null):RecyclerView.Adapter<News_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val ViewBinding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context)
            ,parent,false)

        return  ViewHolder (ViewBinding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newList!![position]
        holder.bind(news)
    }


    override fun getItemCount(): Int =newList?.size?:0

    fun bindNews(articles: List<News?>?) {
        newList = articles
        notifyDataSetChanged()
    }


    class ViewHolder(val ItemBinding : ItemNewsBinding) : RecyclerView.ViewHolder(ItemBinding.root){

        fun bind(news: News?){
            ItemBinding.news = news
            ItemBinding.invalidateAll()
        }
    }
}