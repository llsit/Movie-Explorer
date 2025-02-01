package com.example.core.design.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MovieTrendCard(
    movie: MovieTrend,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .defaultMinSize(minHeight = 100.dp),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    text = movie.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movie.genre,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    RatingBar(rating = movie.rating)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${(movie.rating * 10).roundToInt() / 10f}",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
//                TrendIndicator(
//                    direction = movie.trendDirection,
//                    popularity = movie.popularity
//                )
            }
        }
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