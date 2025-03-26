package com.example.core.model.model

data class Shelf(
    val type: ShelfType,
    val items: List<ShelfItem>
)

data class ShelfItem(
    val id: Long,
    val originalTitle: String,
    val genreIds: List<Long>,
    val popularity: Double,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String
)
