package com.example.workoutmanger11.android

import android.app.Application
import android.content.Context
import com.example.workoutmanger11.android.di.KoinModule
import com.example.workoutmanger11.core.data.DatabaseDriverFactory
import com.example.workoutmanger11.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    init {
        instance = this


    }
    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }



    override fun onCreate() {
        super.onCreate()

        val context: Context = App.applicationContext()


        startKoin {

            androidContext(this@App)

            modules(KoinModule)
        }
    }

}