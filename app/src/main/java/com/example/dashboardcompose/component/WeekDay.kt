package com.example.dashboardcompose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardcompose.ui.theme.blackLight
import com.example.dashboardcompose.ui.theme.dateCardColor
import com.example.dashboardcompose.ui.theme.grey
import com.example.dashboardcompose.ui.theme.lightGrey
import com.example.dashboardcompose.ui.theme.whiteColor
import com.example.dashboardcompose.ui.theme.yellow

data class WeekDay(val day: String, val date: Int)

@Composable
fun WeekDaySelector(
    days: List<WeekDay>,
    selectedIndex: Int,
    onDaySelected: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        days.forEachIndexed { index, weekDay ->
            val isSelected = index == selectedIndex
            Card(
                modifier = Modifier
                    .width(if (isSelected) 40.dp else 36.dp)
                    .height(if (isSelected) 86.dp else 80.dp)
                    .clickable { onDaySelected(index) },
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) yellow else dateCardColor
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = weekDay.day,
                        fontSize = 12.sp,
                        fontFamily = firasans_medium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                        color = if (isSelected) Color.White else grey
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = if (isSelected) whiteColor else lightGrey,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = weekDay.date.toString(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = firasans_medium,
                            color = blackLight
                        )
                    }
                }
            }
        }
    }
}
