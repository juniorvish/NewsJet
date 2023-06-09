package com.newsjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.newsjet.ui.components.BottomNavigation
import com.newsjet.ui.screens.BookmarksScreen
import com.newsjet.ui.screens.HomeScreen
import com.newsjet.ui.screens.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("bookmarks") { BookmarksScreen(navController) }
                composable("profile") { ProfileScreen() }
            }
            BottomNavigation(navController)
        }
    }
}