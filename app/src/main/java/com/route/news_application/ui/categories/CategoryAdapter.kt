package com.route.news_application.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.news_application.databinding.ItemCategoriesBinding

class CategoryAdapter (private var category : List<categoryDataClass>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var viewBinding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context),false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = category.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var category = category.get(position)
        holder.bind(category)

    }

    class ViewHolder(var viewBinding: ItemCategoriesBinding) : RecyclerView.ViewHolder
        (viewBinding.root){
        fun bind(categoryDataClass: categoryDataClass) {
            viewBinding.vm=categoryDataClass
            viewBinding.invalidateAll()
        }
    }
}