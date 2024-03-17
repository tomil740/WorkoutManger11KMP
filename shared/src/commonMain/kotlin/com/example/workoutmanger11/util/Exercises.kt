package com.example.workoutmanger11.util

import com.example.workoutmanger11.workoutTracker.domain.models.Muscle

enum class ExercisesAbstract(exerciseName:String, musclesLst: List<Muscle>) {

     PullUp("PullUp", listOf( Muscles.Back , Muscles.Biceps )) ,
     Squat("Squat", listOf( Muscles.Legs)) ,
     BenchPress("BenchPress", listOf( Muscles.Chest , Muscles.Triceps ) ),

}
