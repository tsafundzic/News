package ch.nth.news2018.tsafundzic.interaction

import ch.nth.news2018.tsafundzic.model.Article

interface ArticleInteractor {

    interface ResponseInterface<in T> {

        fun onArticlesSuccess(data: T)

        fun onArticlesError()
    }

    fun getArticles(responseInterface: ResponseInterface<List<Article>>)
}