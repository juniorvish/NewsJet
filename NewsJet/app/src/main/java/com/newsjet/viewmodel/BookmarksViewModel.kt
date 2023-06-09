package com.newsjet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsjet.data.model.NewsArticle
import com.newsjet.data.repository.BookmarksRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class BookmarksViewModel @Inject constructor(private val bookmarksRepository: BookmarksRepository) : ViewModel() {

    val bookmarkedNews = bookmarksRepository.getBookmarkedNews()

    fun fetchBookmarkedNews() {
        viewModelScope.launch {
            bookmarksRepository.fetchBookmarkedNews()
        }
    }

    fun bookmarkNews(newsArticle: NewsArticle) {
        viewModelScope.launch {
            bookmarksRepository.bookmarkNews(newsArticle)
        }
    }

    fun removeBookmark(newsArticle: NewsArticle) {
        viewModelScope.launch {
            bookmarksRepository.removeBookmark(newsArticle)
        }
    }
}