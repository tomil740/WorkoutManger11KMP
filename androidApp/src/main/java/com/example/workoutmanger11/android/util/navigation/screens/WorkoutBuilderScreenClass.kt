package com.example.workoutmanger11.android.util.navigation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.screen.Screen
import com.example.workoutmanger11.android.workoutTracker.presentation.screens.WorkoutBuilderScreen
import com.example.workoutmanger11.util.ExerciseBuilderObj
import com.example.workoutmanger11.workoutTracker.domain.models.TrackedExerciseItemModule

class WorkoutBuilderScreenClass(
    val setValues: List<ExerciseBuilderObj> = listOf()
):Screen {
    @Composable
    override fun Content() {

        val theExercise = mutableListOf<ExerciseBuilderObj>()


        if(setValues.isNotEmpty()){
            for(i in setValues){
                if(i.reps.value != "" && i.weight.value != "")
                    theExercise.add(
                        ExerciseBuilderObj(mutableStateOf(i.reps.value),mutableStateOf(i.weight.value))
                    )
            }

        }
        var a : TrackedExerciseItemModule? = null
        if(theExercise.size > 0){
            a = TrackedExerciseItemModule("new",theExercise)
        }
        WorkoutBuilderScreen(a)
    }

}