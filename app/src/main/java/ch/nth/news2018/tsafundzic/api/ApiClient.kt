package ch.nth.news2018.tsafundzic.api

import ch.nth.news2018.tsafundzic.interaction.ArticleInteractor
import ch.nth.news2018.tsafundzic.interaction.ArticleInteractorImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        private val BASE_URL: String = "https://newsapi.org/"
        private lateinit var retrofit: Retrofit

        private fun getApi(): ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        private fun getClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }

        fun getArticleInteractor(): ArticleInteractor = ArticleInteractorImpl(getApi())

    }
}
