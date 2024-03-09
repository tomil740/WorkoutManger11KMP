package com.example.workoutmanger11.workoutTracker.domain

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getExercise() : Flow<List<String?>>
        //will return the flow from the useCase/dao


    fun insertExercise()



}