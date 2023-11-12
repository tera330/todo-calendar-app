package com.example.calendar.ui.theme.screenparts.Calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun DayOfWeek() {
    val dayOfWeek = listOf("日", "月", "火", "水", "木", "金", "土")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        for (i in dayOfWeek) {
            Text(
                text = i,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun DayOfWeekPreview() {
    DayOfWeek()
}

