package com.newsjet.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsjet.data.model.NewsArticle
import com.newsjet.data.db.dao.BookmarksDao

@Database(entities = [NewsArticle::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarksDao

    companion object {
        const val DATABASE_NAME = "news_database"
    }
}