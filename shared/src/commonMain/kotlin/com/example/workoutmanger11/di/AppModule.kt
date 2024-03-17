package com.example.workoutmanger11.di


import com.example.workoutmanger11.workoutTracker.domain.Repository


expect class AppModule {
    val repository : Repository
}