package com.example.dashboardcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboardcompose.screen.HomeScreen
import com.example.dashboardcompose.ui.theme.bgColor

@Composable
fun Navigation(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { CustomBottomBar(navController) }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
                .background(bgColor)
        ){
                composable("home") {
                    HomeScreen()
                }
                composable("notifications") { ScreenContent("Notifications Screen") }
                composable("add") { ScreenContent("Add Screen") }
                composable("profile") { ScreenContent("Profile Screen") }
                composable("settings") { ScreenContent("Settings Screen") }

        }

    }
}

@Composable
fun ScreenContent(text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        Text(text, style = MaterialTheme.typography.headlineMedium)
    }
}