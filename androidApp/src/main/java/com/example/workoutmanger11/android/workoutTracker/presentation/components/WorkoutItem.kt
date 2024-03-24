package com.example.workoutmanger11.android.workoutTracker.presentation.components

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.workoutmanger11.android.util.navigation.screens.ExerciseBuilderScreenClass

@Composable
fun WorkoutItem(modifier: Modifier,onEditClick : (name:String) -> Unit = {},onStartClick : (name:String) -> Unit={} ){

    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .border(7.dp,MaterialTheme.colorScheme.primary).
            padding(16.dp)

        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "AB Workout",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    MuscleItem("Shoulders")
                    MuscleItem("Back", isMain = true)
                    MuscleItem("Arms")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    MuscleItem("Legs")
                    MuscleItem("Abs")
                }

                Row( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(text = "Average time : 56 Minuets",style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer)

                    Row(modifier=Modifier.offset(y=25.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(25f))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        )
                        {

                            Icon(
                                imageVector = Icons.Default.Edit, contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        onStartClick("AB")
                                    }
                            )
                        }
                        
                        Spacer(modifier = Modifier.width(12.dp))
                        
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(25f))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center)
                        {

                            Icon(
                                imageVector = Icons.Default.PlayArrow, contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable {
                                        onEditClick("AB")
                                    }
                            )
                        }
                    }
                }

                Text(text = "WorkoutLevel",style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer)

                WeekSumBar(weekTarget = 1f, value = 0.75f, modifier = Modifier.size(width = 180.dp, height = 24.dp))
            }
        }
    }
}

@Preview
@Composable
fun WorkoutItemPreview() {
    WorkoutItem(modifier = Modifier.padding(6.dp),)
}