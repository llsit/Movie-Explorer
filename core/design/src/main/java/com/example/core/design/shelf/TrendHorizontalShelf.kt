package com.example.core.design.shelf

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.design.component.MovieItem
import com.example.core.design.component.MovieTrendCard
import com.example.core.design.component.TitleShelf

@Composable
fun TrendHorizontalShelf(modifier: Modifier = Modifier) {
    val movies = listOf(
        MovieItem("Avatar: The Way Of Water", "3h 12m"),
        MovieItem("Glass Onion: A Knives Out", "3h 12m"),
        MovieItem("The School for Good and Evil", "3h 12m")
    )

    Column(modifier = modifier) {
        TitleShelf(title = "Latest Movies") { }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) { movie ->
                MovieTrendCard(movie)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTendComponent() {
    TrendHorizontalShelf()
}