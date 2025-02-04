package com.example.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.design.shelf.AutoHorizontalContentPager
import com.example.core.design.shelf.TrendShelf

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            AutoHorizontalContentPager()

            TrendShelf(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}