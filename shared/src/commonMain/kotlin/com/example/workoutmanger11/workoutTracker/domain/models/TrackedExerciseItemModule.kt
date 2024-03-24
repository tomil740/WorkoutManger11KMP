package com.example.workoutmanger11.workoutTracker.domain.models

import com.example.workoutmanger11.util.ExerciseBuilderObj

data class TrackedExerciseItemModule(
    //should be an exercise from the enum , for the exapmple we will use just the name as astrign
    val exerciseName: String,
    val setsTargets: List<ExerciseBuilderObj>
)
