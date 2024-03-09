package com.example.workoutmanger11

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform