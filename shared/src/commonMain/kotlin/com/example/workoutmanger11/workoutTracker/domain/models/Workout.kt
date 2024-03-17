package com.example.workoutmanger11.workoutTracker.domain.models

import com.example.workoutmanger11.util.ExercisesAbstract


data class Workout(
    val name : String,
    val musclesLst : List<Muscle>,
    val exerciseLst : List<ExercisesAbstract>

)
