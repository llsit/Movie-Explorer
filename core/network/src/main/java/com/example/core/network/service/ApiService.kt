package com.example.core.network.service

import com.example.core.model.response.GenreListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("genre/movie/list?language=en")
    suspend fun fetchGenres(): Response<GenreListResponse>
}
