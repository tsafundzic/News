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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = PagerAdapter(supportFragmentManager, this)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)

    }

}
