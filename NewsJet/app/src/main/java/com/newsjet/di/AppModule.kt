package com.newsjet.di

import com.newsjet.data.api.NewsApiService
import com.newsjet.data.db.NewsDatabase
import com.newsjet.data.repository.BookmarksRepository
import com.newsjet.data.repository.NewsRepository
import com.newsjet.viewmodel.BookmarksViewModel
import com.newsjet.viewmodel.HomeViewModel
import com.newsjet.viewmodel.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(): NewsDatabase {
        return NewsDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApiService: NewsApiService): NewsRepository {
        return NewsRepository(newsApiService)
    }

    @Provides
    @Singleton
    fun provideBookmarksRepository(newsDatabase: NewsDatabase): BookmarksRepository {
        return BookmarksRepository(newsDatabase)
    }

    @Provides
    @Singleton
    fun provideHomeViewModel(newsRepository: NewsRepository): HomeViewModel {
        return HomeViewModel(newsRepository)
    }

    @Provides
    @Singleton
    fun provideBookmarksViewModel(bookmarksRepository: BookmarksRepository): BookmarksViewModel {
        return BookmarksViewModel(bookmarksRepository)
    }

    @Provides
    @Singleton
    fun provideProfileViewModel(): ProfileViewModel {
        return ProfileViewModel()
    }
}