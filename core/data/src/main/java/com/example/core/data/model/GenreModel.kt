package com.example.core.data.model

import com.squareup.moshi.Json

data class GenreModel(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
)

data class GenreListResponse(
    @Json(name = "genres") val genres: List<GenreModel>
)