import org.gradle.api.JavaVersion

object Java {
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
    const val jvmTarget = "17"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val androidLibrary = "com.android.library"

    const val kotlinJvm = "org.jetbrains.kotlin.jvm"
    const val javaLibrary = "java-library"

    const val kapt = "kotlin-kapt"
    const val hilt = "com.google.dagger.hilt.android"
}

object ClassPath {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20"
    const val gradle = "com.android.tools.build:gradle:8.0.2"

    internal const val hilt_version = "2.46.1"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
}

object Android {

    const val nameSpace = "yakov.dev.type_hero"
    const val compileSdk = 33

    object DefaultConfig {
        const val applicationId = nameSpace
        const val minSdk = 24
        const val targetSdk = 33
        const val versionCode = 1
        const val versionName = "1.0"
        const val useSupportLibrary = true
    }

    object Proguard {
        const val proguardFileName = "proguard-android-optimize.txt"
        const val proguardRulesPro = "proguard-rules.pro"
    }

    object Packaging {
        const val excludes = "/META-INF/{AL2.0,LGPL2.1}"
    }
}

object ComposeOptions {
    const val kotlinCompilerExtensionVersion = "1.4.6"
}
