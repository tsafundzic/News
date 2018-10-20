package ch.nth.news2018.tsafundzic.model

import ch.nth.news2018.tsafundzic.Mappable


data class ArticlesResponse(var articles: List<Article>) : Mappable<List<Article>> {

    override fun mapToData(): List<Article> = articles
}