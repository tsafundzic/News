package ch.nth.news2018.tsafundzic.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ch.nth.news2018.tsafundzic.R
import ch.nth.news2018.tsafundzic.common.toast
import ch.nth.news2018.tsafundzic.listener.OnArticleClickListener
import ch.nth.news2018.tsafundzic.mainPresenter
import ch.nth.news2018.tsafundzic.model.Article
import ch.nth.news2018.tsafundzic.presentation.MainInterface
import ch.nth.news2018.tsafundzic.ui.articles.ArticleAdapter
import ch.nth.news2018.tsafundzic.ui.details.ArticleDetails


class ArticlesTopListFragment : Fragment(), MainInterface.View, OnArticleClickListener {

    private val presenter by lazy { mainPresenter() }
    private val adapter by lazy { ArticleAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_articles_list, container, false)

        presenter.setView(this)

        val articlesList: RecyclerView = view.findViewById(R.id.articlesList)
        articlesList.layoutManager = LinearLayoutManager(context)
        articlesList.adapter = adapter

        presenter.getTopArticles()

        return view
    }

    override fun showArticles(articles: List<Article>) {
        adapter.setArticles(articles)
    }

    override fun showArticleError() {
        context?.toast(getString(R.string.no_data))
    }

    override fun onArticleClick(article: Article) {
        startActivity(
            context?.let {
                ArticleDetails.getLaunchIntent(
                    it,
                    article.title,
                    article.author,
                    article.description,
                    article.publishedAt,
                    article.urlToImage,
                    article.url
                )
            }
        )
    }

}
