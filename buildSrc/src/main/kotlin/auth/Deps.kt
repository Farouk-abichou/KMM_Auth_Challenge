package auth

object Deps {

    // COMPOSE
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"

    //ComposeNavigation
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}"

    //CoilCompose
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilComposeVersion}"

    // KTOR
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
    const val ktorCio = "io.ktor:ktor-client-cio:${Versions.ktorVersion}"
    const val ktorAuth = "io.ktor:ktor-client-auth:${Versions.ktorVersion}"
    const val ktorSerialization = "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktorVersion}"
    const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktorVersion}"
    const val ktorIOS = "io.ktor:ktor-client-ios:${Versions.ktorVersion}"

    // GRADLE PLUGINS
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    const val androidBuildTools = "com.android.tools.build:gradle:${Versions.gradleVersion}"

    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelightGradleVersion}"


    // SQLDELIGHT
    const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:${Versions.sqlDelightVersion}"
    const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelightVersion}"
    const val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelightVersion}"
    const val sqlDelightCoroutinesExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelightVersion}"

    //MVIKotlin
    const val mviKotlin = "com.arkivanov.mvikotlin:mvikotlin:${Versions.mviKotlinVersion}"
    const val mviKotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:${Versions.mviKotlinVersion}"
    const val mviKotlinCoroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:${Versions.mviKotlinVersion}"

    //Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"


    //Settings Data
    const val settingsData = "com.russhwolf:multiplatform-settings:${Versions.settingsDataVersion}"
    const val settingsDataNoArg = "com.russhwolf:multiplatform-settings-no-arg:${Versions.settingsDataVersion}"
    const val settingsDataStore = "com.russhwolf:multiplatform-settings-datastore:${Versions.settingsDataVersion}"

    //Koin
    const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
}