@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.hilt)
    id(Plugins.kapt)
}

android {
    namespace = Modules.App.nameSpace
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.DefaultConfig.applicationId
        minSdk = Android.DefaultConfig.minSdk
        targetSdk = Android.DefaultConfig.targetSdk
        versionCode = Android.DefaultConfig.versionCode
        versionName = Android.DefaultConfig.versionName

        vectorDrawables { useSupportLibrary = Android.DefaultConfig.useSupportLibrary }
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
    packaging {
        resources {
            excludes += Android.Packaging.excludes
        }
    }
}

dependencies {

    implementation(project(Modules.Presentation.path))
    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
}