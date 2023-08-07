import ClassPath.hilt_version

object Core {
    const val coreKtx = "androidx.core:core-ktx:1.10.1"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
}

object Compose {
    private const val compose_version = "1.4.3"

    const val composeUi = "androidx.compose.ui:ui:$compose_version"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:$compose_version"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$compose_version"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$compose_version"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest:$compose_version"

    const val activityCompose = "androidx.activity:activity-compose:1.7.2"
    const val material3 = "androidx.compose.material3:material3:1.1.1"

    const val navigation = "androidx.navigation:navigation-compose:2.6.0"
}

object Bom {
    const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:1.8.20"
    const val composeBom = "androidx.compose:compose-bom:2023.06.00"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1"
}

object DataStore {
    const val dataStorePreferences = "androidx.datastore:datastore-preferences:1.0.0"
}

object Accompanist {
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta"
}

object Hilt {
    const val hiltAndroid =  "com.google.dagger:hilt-android:$hilt_version"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$hilt_version"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.1.0-alpha01"
}

object Retrofit {
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11"
    const val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
}

object Gson {
    const val gson = "com.google.code.gson:gson:2.10.1"
}

object Window {
    const val windowManager = "androidx.window:window:1.1.0"
}