package com.example.workoutmanger11.core.data

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory{
    fun create(): SqlDriver

}



