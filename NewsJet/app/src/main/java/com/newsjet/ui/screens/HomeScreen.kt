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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.newsjet.ui.components.BottomNavigation
import com.newsjet.ui.components.NewsCard
import com.newsjet.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navigateToNewsDetails: (Int) -> Unit,
    navigateToBookmarks: () -> Unit,
    navigateToProfile: () -> Unit
) {
    val homeViewModel: HomeViewModel = viewModel()
    val news by homeViewModel.news.collectAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navigateToHome = {},
                navigateToBookmarks = navigateToBookmarks,
                navigateToProfile = navigateToProfile
            )
        }
    ) {
        LazyColumn {
            items(news) { newsArticle ->
                NewsCard(newsArticle) {
                    navigateToNewsDetails(newsArticle.id)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen({}, {}, {})
}