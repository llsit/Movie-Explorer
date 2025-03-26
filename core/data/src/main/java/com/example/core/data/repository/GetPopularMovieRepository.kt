package com.example.core.data.repository

import com.example.common.Result
import com.example.core.model.response.PopularMovieResponse
import com.example.core.network.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetPopularMovieRepository {
    fun fetchPopular(): Flow<Result<PopularMovieResponse>>
}

class GetPopularMovieRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : GetPopularMovieRepository {
    override fun fetchPopular(): Flow<Result<PopularMovieResponse>> = flow {
        val response = apiService.fetchPopular()
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
