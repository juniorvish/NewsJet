package com.newsjet.data.repository

import com.newsjet.data.api.NewsApiService
import com.newsjet.data.db.dao.BookmarksDao
import com.newsjet.data.model.NewsArticle
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService,
    private val bookmarksDao: BookmarksDao
) {
    suspend fun getNews(): List<NewsArticle> {
        return newsApiService.getNews().articles.map { it.toNewsArticle() }
    }

    suspend fun getBookmarkedNews(): List<NewsArticle> {
        return bookmarksDao.getBookmarkedNews()
    }

    suspend fun bookmarkNews(newsArticle: NewsArticle) {
        bookmarksDao.insertBookmark(newsArticle)
    }

    suspend fun removeBookmark(newsArticle: NewsArticle) {
        bookmarksDao.deleteBookmark(newsArticle)
    }
}