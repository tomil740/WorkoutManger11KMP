package com.example.workoutmanger11.core.data

import android.content.Context
import com.example.workoutmanger11.database.exercisedb
import com.example.workoutmanger11.di.AppModule
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import kotlin.contracts.contract

actual class DatabaseDriverFactory(val context: Context) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(
            exercisedb.Schema,
            context = context,
            "contact.db"
        )
    }
}





