package com.example.dashboardcompose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dashboardcompose.ui.theme.grey
import com.example.dashboardcompose.ui.theme.whiteColor
import com.example.dashboardcompose.ui.theme.yellow

@Composable
fun CustomBottomBar(navController: NavController){
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = listOf(
        Pair("home", Icons.Default.Home),
        Pair("notifications", Icons.Default.Notifications),
        Pair("add", Icons.Default.Add),
        Pair("profile", Icons.Default.Person),
        Pair("settings", Icons.Default.Settings)
    )

    NavigationBar(
        containerColor = whiteColor,
        contentColor = Color.Gray,
        modifier = Modifier.navigationBarsPadding()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        items.forEachIndexed { index, item ->
            val route = item.first
            val icon = item.second

            if (index== 2){
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color.Black, CircleShape)
                        .clickable {
                            selectedIndex = index
                            navController.navigate(route)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            } else{
                Icon(
                    imageVector = icon,
                    contentDescription = route,
                    tint = if (selectedIndex == index) yellow else grey,
                    modifier = Modifier
                        .size(28.dp)
                        .weight(1f)
                        .clickable {
                            selectedIndex = index
                            navController.navigate(route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                )
            }
        }
    }

}