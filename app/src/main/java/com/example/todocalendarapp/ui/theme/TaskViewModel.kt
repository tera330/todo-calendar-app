package com.example.todocalendarapp.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel: ViewModel() {
    private val _taskUiState = MutableStateFlow(TaskUiState())
    val taskUiState: StateFlow<TaskUiState> = _taskUiState.asStateFlow()

    //タスク
    private var taskTitle: String = ""
    private val taskMemo: String = ""


    fun updateState(input: String) {
        _taskUiState.value = _taskUiState.value.copy(
            taskTitle = input,
            taskMemo = input
        )
    }
}