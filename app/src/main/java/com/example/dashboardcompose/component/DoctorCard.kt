package com.example.dashboardcompose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardcompose.R
import com.example.dashboardcompose.ui.theme.blackLight
import com.example.dashboardcompose.ui.theme.dateCardColor
import com.example.dashboardcompose.ui.theme.grey
import com.example.dashboardcompose.ui.theme.lightPink
import com.example.dashboardcompose.ui.theme.whiteColor
import com.example.dashboardcompose.ui.theme.yellow

//@Preview
@Composable
fun DoctorCard(
    name: String,
    specialty: String,
    rating: Double,
    backgroundColor: Color,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(120.dp)
            .height(130.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Doctor",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(color = dateCardColor)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = whiteColor,
                            shape = RoundedCornerShape(
                                topStart = 12.dp,
                                bottomStart = 12.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = yellow,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = rating.toString(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = blackLight,
//                        fontFamily = firasans_bold
                    )
                }

            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
//                    fontFamily = firasans_bold,
                    color = blackLight
                )
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = specialty,
                style = TextStyle(
                    color = grey,
                    fontSize = 11.sp,
//                    fontFamily = firasans_medium
                )
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DoctorCardPreview() {
    DoctorCard(
        name = "Jyoti",
        specialty = "Cardiologist",
        rating = 4.7,
        backgroundColor = lightPink,
        imageRes = R.drawable.lady_dr
    )
}

