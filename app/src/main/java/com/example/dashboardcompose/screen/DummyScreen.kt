package com.example.dashboardcompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardcompose.component.firasans_medium
import com.example.dashboardcompose.ui.theme.bgColor
import com.example.dashboardcompose.ui.theme.grey

@Composable
fun DummyScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Dummy",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = grey,
            fontFamily = firasans_medium
        )
    }
}