package com.route.news_application.ui.categories

import com.route.news_application.R

data class categoryDataClass(
    var id : String,
    var name: String,
    var imageId: Int,
    var BackgroundColor:Int
) {
    companion object{
        fun getCategoryList():List<categoryDataClass>{
            return listOf(
                categoryDataClass("sports" , "Sports" , R.drawable.ball , R.color.red),
                categoryDataClass("business" , "Business" , R.drawable.bussines , R.color.brown),
                categoryDataClass("health" , "Health" , R.drawable.health , R.color.bark),
                categoryDataClass("entertainment" , "Politics" , R.drawable.politics , R.color.blue),
                categoryDataClass("technology" , "Environment" , R.drawable.environment , R.color.gray),
                categoryDataClass("science" , "Science" , R.drawable.science , R.color.yellow)
            )
        }
    }
}
