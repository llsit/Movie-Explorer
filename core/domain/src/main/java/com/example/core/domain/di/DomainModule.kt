package com.example.core.domain.di

import com.example.core.data.repository.GetPopularMovieRepository
import com.example.core.domain.usecase.GetHomeShelfUseCase
import com.example.core.domain.usecase.GetHomeShelfUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetHomeShelfUseCase(
        getPopularMovieRepository: GetPopularMovieRepository
    ): GetHomeShelfUseCase = GetHomeShelfUseCaseImp(getPopularMovieRepository)

}