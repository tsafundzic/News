package ch.nth.news2018.tsafundzic.model


data class Article(
    val author: String,
    val title: String,
    val description: String,
    val publishedAt: String,
    val urlToImage: String,
    val url: String
)
