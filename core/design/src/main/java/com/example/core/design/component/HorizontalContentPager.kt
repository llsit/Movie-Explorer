package com.example.core.design.component

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

@Composable
fun HorizontalContentPager(pagerState: PagerState, colorList: List<Color>) {
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
