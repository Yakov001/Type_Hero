@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.hilt)
    id(Plugins.kapt)
}

android {
    namespace = Modules.Data.nameSpace
    compileSdk = Android.compileSdk

    defaultConfig {
        minSdk = Android.DefaultConfig.minSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(Android.Proguard.proguardFileName),
                Android.Proguard.proguardRulesPro
            )
        }
    }
    compileOptions {
        sourceCompatibility = Java.sourceCompatibility
        targetCompatibility = Java.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Java.jvmTarget
    }
}

dependencies {

    implementation(project(Modules.Domain.path))

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    
    // Room
    implementation(Room.base)
    implementation(Room.coroutines)
    kapt(Room.compiler)
}