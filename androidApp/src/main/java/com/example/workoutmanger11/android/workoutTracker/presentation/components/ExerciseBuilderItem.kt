package com.example.workoutmanger11.android.workoutTracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseBuilderItem(unEmphaseColor:Color,setIndex:Int) {

    val reps = remember { mutableStateOf("") }
    val weight = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth(0.75f)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.extraLarge
            )
    ) {

        val theModifier: Modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

        Row(
            modifier = theModifier,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Set $setIndex",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }

        Row(
            modifier = theModifier
                .fillMaxSize()
                .padding(start = 2.dp, bottom = 6.dp), horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedTextField(
                 reps.value,{a:String-> reps.value = a},
                shape = MaterialTheme.shapes.extraLarge,
                label = { Text(text = "Enter the exercise reps ") },
            )
        }
        Row(
            modifier = theModifier
                .fillMaxWidth()
                .padding(start = 2.dp, bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedTextField(
                weight.value,{a:String-> weight.value = a},
                shape = MaterialTheme.shapes.extraLarge,
                label = { Text(text = "Enter weight ") }
            )
        }
    }
}