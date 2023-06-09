package com.newsjet.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.newsjet.R

@Composable
fun NewsJetBottomNavigation(
    onNavigateToHome: () -> Unit,
    onNavigateToBookmarks: () -> Unit,
    onNavigateToProfile: () -> Unit
) {
    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = { stringResource(R.string.home) },
            onClick = onNavigateToHome
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Bookmarks, contentDescription = null) },
            label = { stringResource(R.string.bookmarks) },
            onClick = onNavigateToBookmarks
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
            label = { stringResource(R.string.profile) },
            onClick = onNavigateToProfile
        )
    }
}