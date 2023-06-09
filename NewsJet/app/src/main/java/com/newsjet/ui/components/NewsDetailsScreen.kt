package com.newsjet.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.newsjet.data.model.NewsArticle
import com.newsjet.viewmodel.BookmarksViewModel

@Composable
fun NewsDetailsScreen(newsArticle: NewsArticle, bookmarksViewModel: BookmarksViewModel) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = newsArticle.title, style = MaterialTheme.typography.h4)
        Text(text = newsArticle.description, style = MaterialTheme.typography.body1)
        Text(text = newsArticle.source, style = MaterialTheme.typography.caption)
        Text(text = newsArticle.publishedAt, style = MaterialTheme.typography.caption)

        val isBookmarked = bookmarksViewModel.isBookmarked(newsArticle.id)
        val bookmarkActionText = if (isBookmarked) "Remove Bookmark" else "Add Bookmark"

        Button(onClick = {
            if (isBookmarked) {
                bookmarksViewModel.removeBookmark(newsArticle.id)
            } else {
                bookmarksViewModel.bookmarkNews(newsArticle)
            }
        }) {
            Text(text = bookmarkActionText)
        }
    }
}