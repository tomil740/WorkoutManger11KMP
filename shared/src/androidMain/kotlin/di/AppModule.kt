package com.example.workoutmanger11.di

import android.content.Context
import com.example.workoutmanger11.core.data.DatabaseDriverFactory
import com.example.workoutmanger11.database.exercisedb
import com.example.workoutmanger11.workoutTracker.data.RepositoryImpl
import com.example.workoutmanger11.workoutTracker.domain.Repository


actual class AppModule(
    private val context: Context
) {

    actual val repository: Repository by lazy {
        RepositoryImpl(
            exercisedb(DatabaseDriverFactory(context).create())
        )
    }
}