package com.example.core.data.repository

import com.example.core.data.model.GenreListResponse
import com.example.core.network.service.ApiService
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetMovieGenreRepository {
    fun fetchGenres(): Flow<Result<GenreListResponse>>
}

class GetMovieGenreRepositoryImpl @Inject constructor(
    private val moshi: Moshi,
    private val apiService: ApiService
) : GetMovieGenreRepository {
    override fun fetchGenres(): Flow<Result<GenreListResponse>> = flow {
        val response = apiService.fetchGenres()
        try {
            if (response.isSuccessful) {
                response.body()?.let { jsonString ->
                    val adapter = moshi.adapter(GenreListResponse::class.java)
                    val genreListResponse = adapter.fromJson(jsonString)
                    genreListResponse?.let {
                        emit(Result.success(it))
                    } ?: emit(Result.failure(Exception("Failed to parse JSON.")))
                } ?: emit(Result.failure(Exception("Empty response body.")))
            } else {
                emit(Result.failure(Exception("API error: ${response.code()} ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}