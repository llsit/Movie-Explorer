package com.example.core.design.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MovieTrendCard(
    movie: MovieTrend,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .aspectRatio(ratio = 9f / 16f)
            .defaultMinSize(minHeight = 100.dp),
        shape = CardDefaults.shape,
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        AsyncImage(
            modifier = Modifier.aspectRatio(ratio = 9f / 16f),
            model = Color.Red,
            contentDescription = "Translated description of what the image contains",
            contentScale = ContentScale.Fit,
            onError = { }
        )

    }
}

data class MovieTrend(
    val title: String,
    val rating: Float,
    val popularity: Int,
    val genre: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTendComponent() {
    MovieTrendCard(
        movie = MovieTrend(
            title = "movie4",
            rating = 4.0f,
            popularity = 4,
            genre = "Cartoon"
        ),
        {}
    )
}