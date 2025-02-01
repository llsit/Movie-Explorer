package com.example.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                .padding(padding)
        ) {
            Title()
            Greeting(
                name = "Android",
            )
            TrendShelf(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun Title() {
    Text(
        text = "Title",
        modifier = Modifier.fillMaxWidth()

    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeScreen()
}