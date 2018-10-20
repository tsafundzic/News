package ch.nth.news2018.tsafundzic

import ch.nth.news2018.tsafundzic.interaction.ArticleInteractor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface Mappable<out R> {

    fun mapToData(): R
}

fun <T : Mappable<R>, R> Call<T>.processRequest(callback: ArticleInteractor.ResponseInterface<R>) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.run { callback.onArticlesSuccess(mapToData()) }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            callback.onArticlesError()
        }
    })
}