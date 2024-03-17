package com.example.workoutmanger11.workoutTracker.domain.models

import com.example.workoutmanger11.util.ExercisesAbstract

data class AbstractExerciseModule (
    val exercisesAbstract : ExercisesAbstract ,
    val rpExerciseStatisticModules: ExerciseStatisticModule,
)

