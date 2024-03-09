package com.example.workoutmanger11.workoutTracker.data

import com.example.workoutmanger11.database.exercisedb
import com.example.workoutmanger11.workoutTracker.domain.Exercise
import com.example.workoutmanger11.workoutTracker.domain.Repository
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map


class RepositoryImpl(val dao: exercisedb ):Repository {

    override fun getExercise(): Flow<List<String?>> {
        return dao.exerciseQueries.getExercise().asFlow().mapToList().map { it.map { it.name } }

    }

    override fun insertExercise() {
        dao.exerciseQueries.insertExerciseEntity(name = "ssd", id = null)

    }


}