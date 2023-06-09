package com.newsjet.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.newsjet.data.model.NewsArticle

@Dao
interface BookmarksDao {

    @Query("SELECT * FROM news_article")
    suspend fun getAllBookmarkedNews(): List<NewsArticle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(newsArticle: NewsArticle)

    @Query("DELETE FROM news_article WHERE id = :id")
    suspend fun deleteBookmark(id: String)

}