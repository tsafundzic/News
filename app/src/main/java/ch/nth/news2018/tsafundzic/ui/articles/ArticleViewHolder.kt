package ch.nth.news2018.tsafundzic.ui.articles

import android.support.v7.widget.RecyclerView
import android.view.View
import ch.nth.news2018.tsafundzic.listener.OnArticleClickListener
import ch.nth.news2018.tsafundzic.model.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleViewHolder(itemView: View, private inline val onArticleClickListener: OnArticleClickListener) : RecyclerView.ViewHolder(itemView) {

    fun setArticle(article: Article) = with(itemView) {
        articleTitle.text = article.title

        val publishedDate = article.publishedAt.split("T")
        articlePublishedAt.text = publishedDate[0]

        itemView.setOnClickListener { onArticleClickListener.onArticleClick(article) }
    }
}