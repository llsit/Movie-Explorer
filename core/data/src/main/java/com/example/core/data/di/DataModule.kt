package com.example.core.data.di

import com.example.core.data.repository.GetMovieGenreRepository
import com.example.core.data.repository.GetMovieGenreRepositoryImpl
import com.example.core.network.service.ApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideGetMovieGenreRepository(
        moshi: Moshi,
        apiService: ApiService
    ): GetMovieGenreRepository = GetMovieGenreRepositoryImpl(moshi, apiService)
}