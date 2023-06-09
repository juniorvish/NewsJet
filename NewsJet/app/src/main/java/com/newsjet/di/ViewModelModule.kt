package com.newsjet.di

import com.newsjet.viewmodel.BookmarksViewModel
import com.newsjet.viewmodel.HomeViewModel
import com.newsjet.viewmodel.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ViewModelModule {

    @Singleton
    @Provides
    fun provideHomeViewModel(newsRepository: NewsRepository): HomeViewModel {
        return HomeViewModel(newsRepository)
    }

    @Singleton
    @Provides
    fun provideBookmarksViewModel(bookmarksRepository: BookmarksRepository): BookmarksViewModel {
        return BookmarksViewModel(bookmarksRepository)
    }

    @Singleton
    @Provides
    fun provideProfileViewModel(): ProfileViewModel {
        return ProfileViewModel()
    }
}