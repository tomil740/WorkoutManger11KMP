package com.example.workoutmanger11.android.workoutTracker.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek

@Composable
fun DailyWorktimeBar(maxVal : Float , currentVal : Float ,modifier: Modifier) {

    Box(modifier = modifier.rotate(270f)){

        val backroundColor = MaterialTheme.colorScheme.secondaryContainer
        val color = MaterialTheme.colorScheme.primary

        Canvas(modifier = modifier)
        {

            drawRoundRect(
                color =  backroundColor,
                size = size,
                cornerRadius = CornerRadius(100f,y=100f)
            )
            drawRoundRect(
                color =  color,
                size = Size(
                    width = 0.5f*size.width,
                    height = size.height
                ),
                cornerRadius = CornerRadius(100f,y=0f)
            )


            /*
            drawRoundRect(color = backroundColor,size = Size(size.width,size.height),cornerRadius = CornerRadius(100f),
            )
            drawRoundRect(color =  color, size = Size(
                width = size.width/3f,//(currentVal/maxVal)
                height = size.height), topLeft = Offset(y=70f,x=0f), cornerRadius = CornerRadius(100f)
            )

             */
        }

    }
}

@Composable
fun DailyWorkoutItem(day: DayOfWeek, workoutName : String, workTime: String) {

    val modifier = Modifier.fillMaxWidth().padding(start = 19.dp,end=19.dp)

    Column(modifier = modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        DailyWorktimeBar(maxVal =  6f, currentVal = 3f, modifier = Modifier.size(width = 80.dp, height = 54.dp).offset(y=-10.dp,x= 10.dp))


        Text(text = day.toString(), style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center)

        Box(modifier = Modifier.border(5.dp, MaterialTheme.colorScheme.primary)) {

            Column(Modifier.padding(9.dp)) {

                Text(
                    text = workoutName,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = workTime,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}