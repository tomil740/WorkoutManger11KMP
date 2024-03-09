plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.squareup.sqldelight")
    //alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }




    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }


    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            //koin[add to version controll but something with the versions cause problems espcially in the compose one]
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation("io.insert-koin:koin-compose")

            //moko
            implementation(libs.moko.compose)
            implementation(libs.moko.core)
            implementation(libs.moko.flow)
            implementation(libs.moko.flow.compose)

            //sqlDelight
            implementation(libs.sqlDelight.coroutines)
            implementation(libs.sqlDelight.runtime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        iosMain.dependencies {
            implementation(libs.sqlDelight.native)

        }
    }


}

android {
    namespace = "com.example.workoutmanger11"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    dependencies{
        implementation(libs.sqlDelight.android)




    }
}


sqldelight {
    database("exercisedb") {
        packageName = "com.example.workoutmanger11.database"
        sourceFolders = listOf("sqldelight")
    }
}


