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
import com.example.core.design.component.MovieTrendCard
import com.example.core.design.component.TitleShelf
import com.example.core.model.model.ShelfItem

@Composable
fun TrendHorizontalShelf(modifier: Modifier = Modifier, title: String, items: List<ShelfItem>) {
    Column(modifier = modifier) {
        TitleShelf(title = title) { }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { movie ->
                MovieTrendCard(movie)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTendComponent() {
    TrendHorizontalShelf(items = emptyList(), title = "")
}