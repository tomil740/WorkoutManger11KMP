package com.example.workoutmanger11.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ExerciseBuilderObj(
    val reps: MutableState<String> = mutableStateOf(""),
    val weight: MutableState<String> =  mutableStateOf("")
)
