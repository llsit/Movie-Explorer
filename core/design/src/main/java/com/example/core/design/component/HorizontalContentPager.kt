package com.example.core.design.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalContentPager(pagerState: PagerState, colorList: List<Color>) {
    val padding = when (pagerState.currentPage) {
        0 -> {
            PaddingValues(start = 0.dp, end = 64.dp)
        }

        pagerState.pageCount - 1 -> {
            PaddingValues(start = 64.dp, end = 0.dp)
        }

        else -> {
            PaddingValues(start = 64.dp, end = 64.dp)
        }
    }
    HorizontalPager(
        state = pagerState,
        contentPadding = padding
    ) { page ->
        Card(
            Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Page: $page",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorList[page])
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }
}
