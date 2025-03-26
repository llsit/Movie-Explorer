package com.example.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.design.shelf.AutoHorizontalContentPager
import com.example.core.design.shelf.TopRatedMoviesShelf
import com.example.core.design.shelf.TrendHorizontalShelf
import com.example.core.model.model.ShelfType

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {

    val shelves by homeViewModel.shelves.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            userScrollEnabled = true
        ) {
            items(shelves) { shelf ->
                when (shelf.type) {
                    ShelfType.Popular -> {
                        TrendHorizontalShelf(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            title = shelf.titleShelf,
                            items = shelf.items
                        )
                    }

                    ShelfType.TopRate -> {
                        TopRatedMoviesShelf(
                            title = shelf.titleShelf,
                            items = shelf.items
                        )
                    }

                    ShelfType.Upcoming -> {
                        AutoHorizontalContentPager(
                            title = shelf.titleShelf,
                            items = shelf.items
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}