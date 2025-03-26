package com.example.core.design.shelf

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.core.design.component.TitleShelf
import com.example.core.design.component.TopRatedMovieCard
import com.example.core.model.model.ShelfItem

@Composable
fun TopRatedMoviesShelf(title: String, items: List<ShelfItem>) {
    Column {
        TitleShelf(title) { }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { movie ->
                TopRatedMovieCard(movie)
            }
        }
    }
}

