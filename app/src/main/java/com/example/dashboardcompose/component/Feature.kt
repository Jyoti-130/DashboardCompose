package com.example.dashboardcompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardcompose.R
import com.example.dashboardcompose.ui.theme.blackLight
import com.example.dashboardcompose.ui.theme.dateCardColor
import com.example.dashboardcompose.ui.theme.profileBg
import com.example.dashboardcompose.ui.theme.whiteColor

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    imageRes: Int = R.drawable.lady_dr,
    title: String = "Hospital",
    imageTint: Color? = null
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(52.dp),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = whiteColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 12.dp)
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(dateCardColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Feature Image",
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape)
                        .background(color = dateCardColor),
                    colorFilter = imageTint?.let { ColorFilter.tint(it) }
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 13.sp,
                    color = blackLight,
                    fontFamily = firasans_medium
                ),
                modifier = Modifier
                    .padding(start = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
