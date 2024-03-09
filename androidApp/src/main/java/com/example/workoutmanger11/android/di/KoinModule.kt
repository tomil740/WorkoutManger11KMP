package com.example.workoutmanger11.android.di

import com.example.workoutmanger11.android.App
import com.example.workoutmanger11.di.AppModule
import com.example.workoutmanger11.workoutTracker.presentation.overViewScreen.OverViewViewModel
import org.koin.dsl.module


val KoinModule = module {




    single(createdAtStart = true) {
        OverViewViewModel(AppModule(App.applicationContext()).repository)
    }
}