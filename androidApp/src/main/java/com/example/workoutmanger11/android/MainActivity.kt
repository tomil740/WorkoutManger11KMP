package com.example.workoutmanger11.android

import android.annotation.SuppressLint
import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.example.workoutmanger11.android.util.navigation.screens.ExerciseBuilderScreenClass
import com.example.workoutmanger11.android.util.navigation.screens.OverViewScreen
import com.example.workoutmanger11.android.util.navigation.screens.WorkoutBuilderScreenClass
import com.example.workoutmanger11.android.util.theme.AppTheme
import com.example.workoutmanger11.android.workoutTracker.presentation.components.DailyWorkoutItem
import com.example.workoutmanger11.android.workoutTracker.presentation.components.DailyWorktimeBar
import com.example.workoutmanger11.android.workoutTracker.presentation.components.GraphGenerator
import com.example.workoutmanger11.android.workoutTracker.presentation.components.Try1
import com.example.workoutmanger11.android.workoutTracker.presentation.components.WorkoutItem
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.ExerciseBuilderScreen
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.OverViewScreen
import java.time.DayOfWeek

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                     Navigator(screen = OverViewScreen())
                 //   GraphGenerator()
                    //Try1()

                }
            }
        }
    }
}

@Composable
fun RowScope.TabItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { tab.options.icon})
    
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    AppTheme {
        GreetingView("Hello, Android!")
    }
}
