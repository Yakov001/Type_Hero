plugins {
    id(Plugins.javaLibrary)
    id(Plugins.kotlinJvm)
}

java {
    sourceCompatibility = Java.sourceCompatibility
    targetCompatibility = Java.targetCompatibility
}

dependencies {
    implementation(Coroutines.core)
    implementation(JavaX.inject)
}