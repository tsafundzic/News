package ch.nth.news2018.tsafundzic.api

import ch.nth.news2018.tsafundzic.model.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/everything")
    fun getArticles(@Query("sources") sources: String, @Query("sortBy") sortBy: String, @Query("apiKey") apiKey: String): Call<ArticlesResponse>

    @GET("v2/top-headlines")
    fun getTopArticles(@Query("sources") sources: String, @Query("sortBy") sortBy: String, @Query("apiKey") apiKey: String): Call<ArticlesResponse>
}