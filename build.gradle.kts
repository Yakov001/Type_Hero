buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ClassPath.gradle)
        classpath(ClassPath.kotlin)
        classpath(ClassPath.hilt)
        classpath(ClassPath.ksp)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}