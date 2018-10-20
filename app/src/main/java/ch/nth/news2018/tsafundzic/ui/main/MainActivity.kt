package ch.nth.news2018.tsafundzic.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ch.nth.news2018.tsafundzic.R
import ch.nth.news2018.tsafundzic.common.toast
import ch.nth.news2018.tsafundzic.listener.OnArticleClickListener
import ch.nth.news2018.tsafundzic.mainPresenter
import ch.nth.news2018.tsafundzic.model.Article
import ch.nth.news2018.tsafundzic.presentation.MainInterface
import ch.nth.news2018.tsafundzic.ui.articles.ArticleAdapter
import ch.nth.news2018.tsafundzic.ui.details.ArticleDetails
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainInterface.View, OnArticleClickListener {

    private val presenter by lazy { mainPresenter() }
    private val adapter by lazy { ArticleAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)

        setAdapter()
        presenter.getArticles()

    }

    private fun setAdapter() {
        articlesList.layoutManager = LinearLayoutManager(this)
        articlesList.adapter = adapter
    }

    override fun showArticles(articles: List<Article>) {
        adapter.setArticles(articles)
    }

    override fun showArticleError() {
        toast(getString(R.string.no_data))
    }

    override fun onArticleClick(article: Article) {
        startActivity(
            ArticleDetails.getLaunchIntent(
                this,
                article.title,
                article.author,
                article.description,
                article.publishedAt,
                article.urlToImage,
                article.url
            )
        )
    }

}
