package com.example.dashboardcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboardcompose.R
import com.example.dashboardcompose.component.DoctorCard
import com.example.dashboardcompose.component.FeatureCard
import com.example.dashboardcompose.component.UpcomingScheduleCard
import com.example.dashboardcompose.component.WeekDay
import com.example.dashboardcompose.component.WeekDaySelector
import com.example.dashboardcompose.component.firasans_medium
import com.example.dashboardcompose.ui.theme.bgColor
import com.example.dashboardcompose.ui.theme.cardGreen
import com.example.dashboardcompose.ui.theme.cardGrey
import com.example.dashboardcompose.ui.theme.grey
import com.example.dashboardcompose.ui.theme.iconBlue
import com.example.dashboardcompose.ui.theme.iconGreen
import com.example.dashboardcompose.ui.theme.iconPurple
import com.example.dashboardcompose.ui.theme.profileBg
import com.example.dashboardcompose.ui.theme.whiteColor

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(profileBg, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bill_gates),
                    contentDescription = "Doctor",
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(profileBg)
                )
            }

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(whiteColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notifications",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(
            hint = "Search by doctor's name",
            onSearch = { query ->
                println("Searching for: $query")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                AppointmentScreen()
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item { FeatureCard(title = "Hospital", imageRes = R.drawable.hospital, imageTint = iconBlue) }
                    item { FeatureCard(title = "Consultant", imageRes = R.drawable.consultant, imageTint = iconGreen) }
                    item { FeatureCard(title = "Clinic", imageRes = R.drawable.clinic, imageTint = iconPurple) }
                    item { FeatureCard(title = "Pharmacy", imageRes = R.drawable.medicine, imageTint = iconBlue) }
                }
            }

            item {

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                Text(
                    text = "Upcoming Schedule",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                    Text(
                        text = "See All",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = grey,
                        fontFamily = firasans_medium
                    )
                }
            }

            item {
                UpcomingScheduleCard(
                    doctorName = "Dr. Lailas Russell",
                    specialty = "Dermatologist Specialist",
                    imageRes = R.drawable.dr,
                    dateTime = "20 September – 12:30 – 10:30 PM",
                    phoneNumber = "7589837494"
                )
            }

            item {
                UpcomingScheduleCard(
                    doctorName = "Dr. Cries Jacks",
                    specialty = "Cardiology Specialist",
                    imageRes = R.drawable.lady_dr,
                    dateTime = "21 September – 09:00 – 05:00 PM",
                    phoneNumber = "7589837494"
                )
            }
        }

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "Search",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(it.text)
        },
        placeholder = {
            Text(
                text = hint,
                fontSize = 16.sp,
                color = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray,
                modifier = Modifier.padding(end = 12.dp)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors().copy(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = whiteColor,
            focusedTextColor = grey,
            unfocusedTextColor = grey,
            unfocusedContainerColor = whiteColor,
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(28.dp),
        textStyle = TextStyle(fontSize = 16.sp,
            fontWeight = FontWeight.Normal)
    )
}

@Composable
fun AppointmentScreen() {
    val days = listOf(
        WeekDay("Sun", 15),
        WeekDay("Mon", 16),
        WeekDay("Tue", 17),
        WeekDay("Wed", 18),
        WeekDay("Thu", 19),
        WeekDay("Fri", 20),
        WeekDay("Sat", 21)
    )

    var selectedDay by remember { mutableIntStateOf(3) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            WeekDaySelector(
                days = days,
                selectedIndex = selectedDay,
                onDaySelected = { selectedDay = it }
            )

            Spacer(modifier = Modifier.height(36.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    DoctorCard(
                        name = "Ralph Edward",
                        specialty = "Dentist Specialist",
                        rating = 4.8,
                        backgroundColor = Color(0xFFFFEBEE),
                        imageRes = R.drawable.dr
                    )
                }
                item {
                    DoctorCard(
                        name = "Bessie Cooper",
                        specialty = "Surgery Specialist",
                        rating = 4.6,
                        backgroundColor = cardGrey,
                        imageRes = R.drawable.lady_dr
                    )
                }
                item {
                    DoctorCard(
                        name = "Annette Black",
                        specialty = "Urology Specialist",
                        rating = 4.2,
                        backgroundColor = cardGreen,
                        imageRes = R.drawable.dr
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

