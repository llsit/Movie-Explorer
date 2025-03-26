package com.example.core.network.service

import com.example.core.model.response.GenreListResponse
import com.example.core.model.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("genre/movie/list?language=en")
    suspend fun fetchGenres(): Response<GenreListResponse>

    @GET("movie/popular")
    suspend fun fetchPopular(): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun fetchTopRated(): Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun fetchUpcoming(): Response<MovieResponse>
}
