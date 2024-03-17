package com.example.workoutmanger11.util

import com.example.workoutmanger11.workoutTracker.domain.models.Muscle

sealed class Muscles: Muscle{

    object Back : Muscles(){
        override val muscleName: String
            get() = "Back"
        override val sizeCategory: String
            get() = "Big"

    }

    object Shoulders : Muscles(){
        override val muscleName: String
            get() = "Shoulders"
        override val sizeCategory: String
            get() = "Medium-small"

    }

    object Legs : Muscles(){
        override val muscleName: String
            get() = "Legs"
        override val sizeCategory: String
            get() = "Big"

    }

    object Chest : Muscles(){
        override val muscleName: String
            get() = "Chest"
        override val sizeCategory: String
            get() = "Big"

    }

    object Abs : Muscles(){
        override val muscleName: String
            get() = "Abs"
        override val sizeCategory: String
            get() = "Small"

    }

    object Triceps : Muscles(){
        override val muscleName: String
            get() = "Triceps"
        override val sizeCategory: String
            get() = "Small"

    }

    object Biceps : Muscles(){
        override val muscleName: String
            get() = "Biceps"
        override val sizeCategory: String
            get() = "Small"

    }




}
