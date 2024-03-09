package com.example.workoutmanger11.di

import com.example.workoutmanger11.core.data.DatabaseDriverFactory
import com.example.workoutmanger11.database.exercisedb
import com.example.workoutmanger11.workoutTracker.data.RepositoryImpl
import com.example.workoutmanger11.workoutTracker.domain.Repository

actual class AppModule{

    actual val repository: Repository by lazy {
        RepositoryImpl(
            exercisedb(DatabaseDriverFactory().create())
        )
    }
}