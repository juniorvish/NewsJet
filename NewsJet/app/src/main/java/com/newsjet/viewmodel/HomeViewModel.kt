package com.newsjet.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsjet.data.model.NewsArticle
import com.newsjet.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    val news = mutableStateOf<List<NewsArticle>>(emptyList())
    val isLoading = mutableStateOf(false)

    init {
        fetchNews()
    }

    fun fetchNews() {
        viewModelScope.launch {
            isLoading.value = true
            val result = newsRepository.getNews()
            if (result.isSuccessful) {
                news.value = result.body() ?: emptyList()
            }
            isLoading.value = false
        }
    }
}