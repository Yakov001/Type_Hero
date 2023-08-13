@file:Suppress("UnstableApiUsage")

plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.hilt)
    id(Plugins.kapt)
}

android {
    namespace = Modules.Presentation.nameSpace
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
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeOptions.kotlinCompilerExtensionVersion
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(Modules.Domain.path))

    // Core
    implementation(Core.coreKtx)
    implementation(Core.lifecycleRuntime)

    // Compose
    implementation(Compose.activityCompose)
//    implementation(Compose.composeUi)
    implementation(Compose.material3)
    implementation(Compose.composeUiGraphics)
    debugImplementation(Compose.composeUiTooling)
    implementation(Compose.composeUiToolingPreview)
    // Navigation
    implementation(Compose.navigation)

    // Accompanist for painting status bar
    implementation(Accompanist.systemUiController)

    // Hilt
    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltNavigationCompose)
    kapt(Hilt.hiltCompiler)
}