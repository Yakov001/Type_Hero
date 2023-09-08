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

    // Testing
    testImplementation(Testing.junit)
    testImplementation(Testing.mockitoCore)
    testImplementation(Testing.mockitoKotlin)
}