package com.example.core.design.shelf

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.design.component.MovieTrend
import com.example.core.design.component.MovieTrendCard

@Composable
fun TrendShelf(modifier: Modifier = Modifier) {
    val movieTendList = listOf(
        MovieTrend(
            title = "movie1",
            rating = 1.0f,
            popularity = 1,
            genre = "Cartoon"
        ),
        MovieTrend(
            title = "movie2",
            rating = 2.0f,
            popularity = 2,
            genre = "Cartoon"
        ),
        MovieTrend(
            title = "movie3",
            rating = 3.0f,
            popularity = 3,
            genre = "Cartoon"
        ),
        MovieTrend(
            title = "movie4",
            rating = 4.0f,
            popularity = 4,
            genre = "Cartoon"
        )
    )
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        movieTendList.forEach { movie ->
            MovieTrendCard(
                movie = movie,
                onClick = {}
            )
        }
    }
}