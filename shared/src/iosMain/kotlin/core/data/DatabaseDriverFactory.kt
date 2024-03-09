package com.example.workoutmanger11.core.data

import com.example.workoutmanger11.database.exercisedb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory{
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(exercisedb.Schema, "contact.db")
    }
}




