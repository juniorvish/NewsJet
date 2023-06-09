package com.newsjet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_articles")
data class NewsArticle(
    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("urlToImage")
    val imageUrl: String,

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("source")
    val source: Source
)

data class Source(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String
)