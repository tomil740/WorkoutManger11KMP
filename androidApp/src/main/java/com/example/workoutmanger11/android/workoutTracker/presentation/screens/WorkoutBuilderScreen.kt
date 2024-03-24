package com.example.workoutmanger11.android.workoutTracker.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.workoutmanger11.android.util.navigation.screens.ExerciseBuilderScreenClass
import com.example.workoutmanger11.android.workoutTracker.presentation.components.AbstractExerciseItem
import com.example.workoutmanger11.android.workoutTracker.presentation.components.TrackedExerciseItem
import com.example.workoutmanger11.util.ExerciseBuilderObj
import com.example.workoutmanger11.workoutTracker.domain.models.TrackedExerciseItemModule
import kotlinx.coroutines.delay

@Composable
fun WorkoutBuilderScreen(
    exercise: TrackedExerciseItemModule? = null
) {
    val trackedExercise : MutableList<TrackedExerciseItemModule> = mutableListOf(
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj())),
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj())),
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj())),
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj())),
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj())),
        TrackedExerciseItemModule("Pull-ups", listOf(ExerciseBuilderObj(),ExerciseBuilderObj(),ExerciseBuilderObj()))
    )

    if(exercise!=null){
        trackedExercise.add(
            exercise
        )
    }



    val navigator = LocalNavigator.currentOrThrow

    val workoutName = remember { mutableStateOf("") }
    val isFloatWorkoutName = remember { mutableStateOf(false) }
    val listState = rememberLazyListState()

    LaunchedEffect(key1 = listState.firstVisibleItemIndex) {

        if (listState.firstVisibleItemIndex != 0) {
            delay(500)
            isFloatWorkoutName.value = true
        } else {
            delay(500)
            isFloatWorkoutName.value = false
        }
    }



    LazyColumn(state = listState) {
        if (!isFloatWorkoutName.value) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 24.dp)
                ) {
                    OutlinedTextField(
                        value = workoutName.value,
                        onValueChange = { text: String ->
                            workoutName.value = text
                        },
                        modifier = Modifier.align(Alignment.Center),
                        shape = MaterialTheme.shapes.extraLarge,
                        supportingText = {
                            Text(text = "Enter workout name ")
                        },
                        suffix = { Text(text = "Workout               ") },
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                    )

                }
            }
        }
        items(trackedExercise.size) {
            TrackedExerciseItem(
                modifier1 = Modifier
                    .padding(16.dp)
                    .clip(MaterialTheme.shapes.extraLarge),
                unEmphaseBackground = MaterialTheme.colorScheme.primaryContainer,
                trackedExercise.get(it)

            )
        }
    }

    if (isFloatWorkoutName.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)

        ) {
            //place the name
            Text(
                text = workoutName.value + " Workout",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onTertiary,
                maxLines = 1,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(24.dp)
            )
        }


    }
    //the add exercise fixed floating button...
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .offset(x = 52.dp, y = 42.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(56.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AnimatedVisibility(visible = !isFloatWorkoutName.value,
                    enter = slideInVertically(
                        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)),
                    exit = slideOutVertically (
                        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)))
                {
                    Text(
                        text = "Add exercise",
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Icon(
                    imageVector = Icons.Default.Add, contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize().offset(y = -25.dp, x = -12.dp)
            .padding(2.dp),
        contentAlignment = Alignment.BottomEnd
    ) {

        Icon(
            imageVector = Icons.Default.Check, contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(32.dp).padding(top = 2.dp).clickable {navigator.push(ExerciseBuilderScreenClass()) }
        )

        Icon(
            imageVector = Icons.Default.Delete, contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(32.dp).offset(x = -28.dp).padding(top = 2.dp).clickable { }
        )
    }
}












