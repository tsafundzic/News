package ch.nth.news2018.tsafundzic.presentation.implementation

import ch.nth.news2018.tsafundzic.interaction.ArticleInteractor
import ch.nth.news2018.tsafundzic.model.Article
import ch.nth.news2018.tsafundzic.presentation.MainInterface

class MainPresenterImpl(private val articleInteractor: ArticleInteractor) : MainInterface.Presenter,
    ArticleInteractor.ResponseInterface<List<Article>> {

    private lateinit var view: MainInterface.View

    override fun setView(view: MainInterface.View) {
        this.view = view
    }

    override fun onArticlesSuccess(data: List<Article>) {
        view.showArticles(data)
    }

    override fun onArticlesError() {
        view.showArticleError()
   }

    override fun getArticles() {
        articleInteractor.getArticles(this)
    }

}