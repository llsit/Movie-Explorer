package com.example.core.data.repository

import com.example.core.data.model.GenreListResponse
import com.example.core.network.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface GetMovieGenreRepository {
    fun fetchGenres(): Flow<GenreListResponse>
}

class GetMovieGenreRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GetMovieGenreRepository {
    override fun fetchGenres(): Flow<GenreListResponse> {
        apiService.fetchGenres()
        return flowOf()
    }
}