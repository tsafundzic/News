package ch.nth.news2018.tsafundzic.presentation

import ch.nth.news2018.tsafundzic.model.Article

interface MainInterface{

    interface View{

        fun showArticles(articles: List<Article>)

        fun showArticleError()

    }

    interface Presenter{

        fun setView(view: View)

        fun getArticles()

    }

}