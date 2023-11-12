package com.example.calendar.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalendarViewModel: ViewModel() {

    private val _calendarUiState = MutableStateFlow(CalendarUiState())
    val calendarUiState: StateFlow<CalendarUiState> = _calendarUiState.asStateFlow()

    //カレンダー
    private var currentMonth: Int = 1

    fun setCurrentPage(page: Int) {
        currentMonth = page
        _calendarUiState.update { currentState ->
            currentState.copy(
                currentMonth = currentMonth.toString()
            )
        }
    }
}
