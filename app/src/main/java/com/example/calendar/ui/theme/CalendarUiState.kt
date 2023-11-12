package com.example.calendar.ui.theme

data class CalendarUiState(
    // カレンダー
    val currentMonth: String = "1"
)

data class TaskUiState(
    // タスク
    var taskTitle: String = "",
    var taskMemo: String = ""
)