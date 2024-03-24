package com.example.workoutmanger11.android.util.navigation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.ExerciseBuilderScreen
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.WorkoutBuilderScreen

object WorkoutBuilderTab: Tab {

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Add)
            val name = "OverView"
            val index: UShort = 0u

            return TabOptions(index = index, title = name, icon = icon)
        }

    @Composable
    override fun Content() {
        ExerciseBuilderScreen()
    }

}