package com.example.todocalendarapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todocalendarapp.ui.theme.CalendarViewModel
import com.example.todocalendarapp.ui.theme.screenparts.Calendar.DayOfWeek
import com.example.todocalendarapp.ui.theme.screenparts.Calendar.PagerCalendar

@Composable
fun CalendarScreen(
    calendarViewModel: CalendarViewModel = viewModel(),
) {
    val calendarUiState by calendarViewModel.calendarUiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text =  "${calendarUiState.currentMonth}月",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
        )
        DayOfWeek()
        PagerCalendar()
    }
}

@Preview
@Composable
fun PreviewCalendarScreen() {
    CalendarScreen()
}