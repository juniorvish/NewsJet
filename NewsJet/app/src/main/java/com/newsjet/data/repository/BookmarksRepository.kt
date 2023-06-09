package com.newsjet.data.repository

import com.newsjet.data.db.dao.BookmarksDao
import com.newsjet.data.model.NewsArticle
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarksRepository @Inject constructor(private val bookmarksDao: BookmarksDao) {

    fun getBookmarkedNews(): Flow<List<NewsArticle>> {
        return bookmarksDao.getBookmarkedNews()
    }

    suspend fun bookmarkNews(newsArticle: NewsArticle) {
        bookmarksDao.insertBookmark(newsArticle)
    }

    suspend fun removeBookmark(newsArticle: NewsArticle) {
        bookmarksDao.deleteBookmark(newsArticle)
    }
}