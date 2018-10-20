package ch.nth.news2018.tsafundzic.listener

import ch.nth.news2018.tsafundzic.model.Article

interface OnArticleClickListener{
    
    fun onArticleClick(article: Article)

    operator fun invoke(article: Article) {

    }

}