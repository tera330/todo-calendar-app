package com.example.todocalendarapp.ui.theme.screenparts.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todocalendarapp.ui.theme.TaskViewModel
import java.time.LocalDate

@Composable
fun DayScheduleScreen(date: LocalDate) {
    val taskViewModel: TaskViewModel = viewModel()
    val taskUiState by taskViewModel.taskUiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "予定を追加する",
            fontSize = 25.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp, bottom = 10.dp),
        )
        InputText(
            value = taskUiState.taskTitle,
            onValueChanged = { taskViewModel.updateState(it) },
            label = "予定",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        InputText(
            value = taskUiState.taskMemo,
            onValueChanged = { taskViewModel.updateState(it) },
            label = "メモ",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    value: String,
    onValueChanged: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange =  onValueChanged,
        label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
        ),
        modifier = modifier
            .width(300.dp)
    )
}

@Preview
@Composable
fun SchedulePreview() {
    DayScheduleScreen(date = LocalDate.of(2023, 1, 1))
}