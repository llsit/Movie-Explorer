package com.example.core.data.repository

import com.example.common.Result
import com.example.core.model.response.GenreListResponse
import com.example.core.network.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetMovieGenreRepository {
    fun fetchGenres(): Flow<Result<GenreListResponse>>
}

class GetMovieGenreRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GetMovieGenreRepository {
    override fun fetchGenres(): Flow<Result<GenreListResponse>> = flow {
        val response = apiService.fetchGenres()
        try {
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.Success(it))
                } ?: emit(Result.Error(Exception("Empty response body.")))
            } else {
                emit(Result.Error(Exception("API error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}