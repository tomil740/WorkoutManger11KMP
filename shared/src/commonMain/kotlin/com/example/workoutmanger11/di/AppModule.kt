package com.example.workoutmanger11.di

import com.example.workoutmanger11.core.data.DatabaseDriverFactory
import com.example.workoutmanger11.database.exercisedb
import com.example.workoutmanger11.workoutTracker.data.RepositoryImpl
import com.example.workoutmanger11.workoutTracker.domain.Repository
import com.example.workoutmanger11.workoutTracker.presentation.overViewScreen.OverViewViewModel
import org.koin.dsl.koinApplication
import org.koin.dsl.module

expect class AppModule {
    val repository : Repository
}