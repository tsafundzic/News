package ch.nth.news2018.tsafundzic.interaction

import ch.nth.news2018.tsafundzic.api.ApiInterface
import ch.nth.news2018.tsafundzic.common.API_KEY
import ch.nth.news2018.tsafundzic.common.SOURCES
import ch.nth.news2018.tsafundzic.model.Article
import ch.nth.news2018.tsafundzic.processRequest

class ArticleInteractorImpl(private val apiInterface: ApiInterface) : ArticleInteractor {

    override fun getArticles(responseInterface: ArticleInteractor.ResponseInterface<List<Article>>) {
        apiInterface.getArticles(SOURCES, API_KEY).processRequest(responseInterface)
    }
}