package com.danunaik.news_data.network

import com.danunaik.common_utils.Constants
import com.danunaik.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApiService {
    //   https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=38b86078bfd64e319f4534359c320cc0
    @GET("top-headlines")
    suspend fun getNewsArticle(
        @Query("country") country:String=Constants.COUNTRY,
        @Query("category") category:String=Constants.CATEGORY,
        @Query("apiKey") apiKey: String= Constants.API_KEY
    ):NewsResponse
}