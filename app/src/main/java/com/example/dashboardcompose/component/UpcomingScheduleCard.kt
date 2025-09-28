package com.example.dashboardcompose.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.dashboardcompose.R
import com.example.dashboardcompose.ui.theme.blackLight
import com.example.dashboardcompose.ui.theme.callIconColor
import com.example.dashboardcompose.ui.theme.dateCardColor
import com.example.dashboardcompose.ui.theme.grey
import com.example.dashboardcompose.ui.theme.iconBlue
import com.example.dashboardcompose.ui.theme.whiteColor
import com.example.dashboardcompose.ui.theme.yellow

@Composable
fun UpcomingScheduleCard(
    doctorName: String,
    specialty: String,
    imageRes: Int,
    dateTime: String,
    phoneNumber: String

) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = whiteColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Doctor",
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(color = Color(0xFFECEFF1))
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = doctorName,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = blackLight,
                                fontFamily = firasans_medium
                            )
                        )
                        Text(
                            text = specialty,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                color = grey,
                                fontFamily = firaSans_regular
                            )
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.messenger),
                        contentDescription = "Chat",
                        tint = iconBlue,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(dateCardColor)
                            .padding(6.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "Call",
                        tint = whiteColor,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(callIconColor)
                            .padding(9.dp)
                            .clickable {
                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = "tel:$phoneNumber".toUri()
                                }
                                context.startActivity(intent)
                            }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = dateTime,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = blackLight,
                        textAlign = TextAlign.Center,
                        fontFamily = firaSans_regular
                    )
                )
            }
        }
    }
}
