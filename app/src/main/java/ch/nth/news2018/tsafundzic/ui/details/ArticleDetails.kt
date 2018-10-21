package ch.nth.news2018.tsafundzic.ui.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ch.nth.news2018.tsafundzic.R
import ch.nth.news2018.tsafundzic.common.*
import ch.nth.news2018.tsafundzic.getIntent
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_article_details.*


class ArticleDetails : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(
            from: Context,
            title: String,
            author: String,
            description: String,
            publishedAt: String,
            urlToImage: String,
            articleLink: String
        ) = from.getIntent<ArticleDetails>().apply {
            putExtra(TITLE, title)
            putExtra(AUTHOR, author)
            putExtra(DESCRIPTION, description)
            putExtra(PUBLISHEDAT, publishedAt)
            putExtra(URLTOIMAGE, urlToImage)
            putExtra(ARTICLELINK, articleLink)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        setArticleDetails()
        articleLink.setOnClickListener { openArticle() }
    }

    private fun openArticle() {
        val intentArticleWeb = Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra(ARTICLELINK)))
        startActivity(intentArticleWeb)
    }

    private fun setArticleDetails() {
        articleAuthor.text = intent.getStringExtra(AUTHOR)
        articleTitle.text = intent.getStringExtra(TITLE)
        articleDetails.text = intent.getStringExtra(DESCRIPTION)
        Glide.with(this).load(intent.getStringExtra(URLTOIMAGE)).into(articleImage)

        articlePublishedAt.text = returnTimeAgo(intent.getStringExtra(PUBLISHEDAT))
    }
}
