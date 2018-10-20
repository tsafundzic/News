package ch.nth.news2018.tsafundzic.ui.articles

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ch.nth.news2018.tsafundzic.R
import ch.nth.news2018.tsafundzic.listener.OnArticleClickListener
import ch.nth.news2018.tsafundzic.model.Article


class ArticleAdapter (private val onArticleClickListener: OnArticleClickListener) : RecyclerView.Adapter<ArticleViewHolder>() {

    private var articles: MutableList<Article> = ArrayList()

    fun setArticles(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view, onArticleClickListener)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.setArticle(article)
    }
}