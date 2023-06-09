package com.newsjet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.newsjet.ui.components.BottomNavigation
import com.newsjet.ui.components.NewsCard
import com.newsjet.viewmodel.BookmarksViewModel

@Composable
fun BookmarksScreen(
    bookmarksViewModel: BookmarksViewModel,
    navController: NavController
) {
    val bookmarkedNews by bookmarksViewModel.bookmarkedNews.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navigateToHome = { navController.navigate("home") },
                navigateToBookmarks = { },
                navigateToProfile = { navController.navigate("profile") }
            )
        }
    ) {
        LazyColumn {
            items(bookmarkedNews) { newsArticle ->
                NewsCard(
                    newsArticle = newsArticle,
                    onClick = { navController.navigate("newsDetails/${newsArticle.id}") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookmarksScreenPreview() {
    Column {
        Text("Bookmarks Screen Preview")
    }
}