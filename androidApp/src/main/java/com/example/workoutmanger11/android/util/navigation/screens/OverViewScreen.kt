package com.example.workoutmanger11.android.util.navigation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.ExerciseBuilderScreen
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.OverViewScreen

class OverViewScreen: Screen {
    @Composable
    override fun Content() {
        OverViewScreen(modifier = Modifier.fillMaxSize())

    }

}