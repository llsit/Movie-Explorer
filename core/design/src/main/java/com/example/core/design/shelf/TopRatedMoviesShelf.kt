package com.example.core.design.shelf

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.design.component.TitleShelf
import com.example.core.design.component.TopRatedMovieCard

data class TopRatedMovie(
    val title: String,
    val status: String,
    val genre: String,
    val duration: String
)

@Composable
fun TopRatedMoviesShelf() {
    val movies = listOf(
        TopRatedMovie(
            title = "The Witcher: Blood Origin",
            status = "On Going",
            genre = "Thriller",
            duration = "3h 12m"
        ),
        TopRatedMovie(
            title = "Avatar: The Way",
            status = "Sci-Fi",
            genre = "Sci-Fi",
            duration = "3h 12m"
        )
    )

    Column {
        TitleShelf("Top rated") { }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) { movie ->
                TopRatedMovieCard(movie)
            }
        }
    }
}

@Composable
@Preview
fun TopRatedMoviesShelfPreview() {
    TopRatedMoviesShelf()
}
