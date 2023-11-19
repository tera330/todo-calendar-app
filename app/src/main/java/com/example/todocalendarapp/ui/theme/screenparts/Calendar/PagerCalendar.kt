package com.example.todocalendarapp.ui.theme.screenparts.Calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todocalendarapp.ui.theme.CalendarViewModel
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerCalendar(
    modifier: Modifier = Modifier,
    calendarViewModel: CalendarViewModel = viewModel(),
) {
    val pagerState = rememberPagerState()
    val year = (2023..2034).toList()

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            pageCount = year.size,
            state = pagerState
        ) { page ->
            calendarViewModel.setCurrentPage(page + 1)
            val basisDate = LocalDate.of(2023,  page + 1, 1)
            val dayOffset = when (basisDate.dayOfWeek) {
                java.time.DayOfWeek.SUNDAY -> 0
                java.time.DayOfWeek.MONDAY -> 1
                java.time.DayOfWeek.TUESDAY -> 2
                java.time.DayOfWeek.WEDNESDAY -> 3
                java.time.DayOfWeek.THURSDAY -> 4
                java.time.DayOfWeek.FRIDAY -> 5
                else -> 6
            }
            var clickedDate by remember { mutableStateOf<LocalDate?>(null) }

            Column {
                for (i in 0 until 6) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        for (j in 1..7) {
                            val displayedDate = basisDate.plusDays((i * 7 + j - 1 - dayOffset).toLong())
                            val isCellClicked = clickedDate == displayedDate

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .border(1.dp, Color.Gray)
                                    .clickable {
                                        clickedDate = displayedDate // セルがクリックされたら、clickedDateを更新
                                    }
                            ) {
                                Text(
                                    text = displayedDate.dayOfMonth.toString(),
                                    modifier = Modifier
                                        .padding(8.dp)
                                )
                                calendarViewModel.setCurrentPage(pagerState.currentPage + 1)

                                if (isCellClicked) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PagerCalendarPreview() {
    PagerCalendar()
}