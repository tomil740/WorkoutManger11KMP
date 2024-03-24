package com.example.workoutmanger11.android.workoutTracker.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.workoutmanger11.android.util.navigation.screens.WorkoutBuilderScreenClass
import com.example.workoutmanger11.android.workoutTracker.presentation.components.DailyWorkoutItem
import com.example.workoutmanger11.android.workoutTracker.presentation.components.WeekSumBar
import com.example.workoutmanger11.android.workoutTracker.presentation.components.WeekSumBarCover
import com.example.workoutmanger11.android.workoutTracker.presentation.components.WorkoutItem
import java.time.DayOfWeek

@Composable
fun OverViewScreen(modifier: Modifier) {

    val navigator = LocalNavigator.currentOrThrow

    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        WeekSumBarCover(Modifier.fillMaxWidth())
/*
        WeekSumBar(weekTarget = 4f, value = 2f, modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))

 */

        Spacer(modifier = Modifier.height(62.dp))

        LazyRow(
            Modifier
                .padding(start = 9.dp, end = 9.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            items(7) {
                DailyWorkoutItem(DayOfWeek.MONDAY, "A Workout", "65 minetus")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


        Box(Modifier.fillMaxWidth()){

            Text(text = "My workouts :", style = MaterialTheme.typography.titleLarge,modifier=Modifier.align(Alignment.Center)
                , color =MaterialTheme.colorScheme.primary )

           Box(modifier= Modifier
               .align(Alignment.TopEnd)
               .padding(16.dp)
               .clip(MaterialTheme.shapes.extraLarge)
               .background(color = MaterialTheme.colorScheme.primary)
               .clickable { navigator.push(WorkoutBuilderScreenClass()) })
           {
               Icon(Icons.Default.Add,null,modifier=Modifier.size(28.dp), tint = MaterialTheme.colorScheme.onPrimary)
           }
        }


        LazyRow{
            items(7){

                WorkoutItem(Modifier.padding(8.dp), onEditClick = { a-> navigator.push(WorkoutBuilderScreenClass())}
                    , onStartClick = { a-> navigator.push(WorkoutBuilderScreenClass())})

            }
        }





    }
}