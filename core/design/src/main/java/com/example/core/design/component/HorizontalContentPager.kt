package com.example.core.design.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.core.model.model.ShelfItem

@Composable
fun HorizontalContentPager(pagerState: PagerState, items: List<ShelfItem>) {
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(start = 64.dp, end = 64.dp)
    ) { page ->
        Card(
            Modifier
                .height(400.dp)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = items[page].posterPath,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
