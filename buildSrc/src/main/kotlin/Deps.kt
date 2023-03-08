object Deps {

    // COMPOSE
    private const val activityComposeVersion = "1.6.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    const val composeVersion = "1.4.0-alpha02"
    const val composeUi = "androidx.compose.ui:ui:$composeVersion"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val composeFoundation = "androidx.compose.foundation:foundation:$composeVersion"
    const val composeMaterial = "androidx.compose.material:material:$composeVersion"
    const val composeIconsExtended = "androidx.compose.material:material-icons-extended:$composeVersion"

    private const val composeNavigationVersion = "2.5.3"
    const val composeNavigation = "androidx.navigation:navigation-compose:$composeNavigationVersion"

    private const val coilComposeVersion = "2.1.0"
    const val coilCompose = "io.coil-kt:coil-compose:$coilComposeVersion"

    // KTOR
    private const val ktorVersion = "2.1.3"
    const val ktorCore = "io.ktor:ktor-client-core:$ktorVersion"
    const val ktorCio = "io.ktor:ktor-client-cio:$ktorVersion"
    const val ktorAuth = "io.ktor:ktor-client-auth:$ktorVersion"
    const val ktorSerialization = "io.ktor:ktor-client-content-negotiation:$ktorVersion"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"
    const val ktorAndroid = "io.ktor:ktor-client-android:$ktorVersion"
    const val ktorOkHttp = "io.ktor:ktor-client-okhttp:$ktorVersion"
    const val ktorIOS = "io.ktor:ktor-client-ios:$ktorVersion"




    // GRADLE PLUGINS
    const val kotlinVersion = "1.7.21"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    private const val gradleVersion = "7.2.2"
    const val androidBuildTools = "com.android.tools.build:gradle:$gradleVersion"

    private const val sqlDelightGradleVersion = "1.5.3"
    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:$sqlDelightGradleVersion"


    // SQLDELIGHT
    private const val sqlDelightVersion = "1.5.4"
    const val sqlDelightRuntime = "com.squareup.sqldelight:runtime:$sqlDelightVersion"
    const val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:$sqlDelightVersion"
    const val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:$sqlDelightVersion"
    const val sqlDelightCoroutinesExtensions = "com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion"

    //MVIKotlin
    private const val mviKotlinVersion = "3.1.0"
    const val mviKotlin = "com.arkivanov.mvikotlin:mvikotlin:$mviKotlinVersion"
    const val mviKotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$mviKotlinVersion"
    const val mviKotlinCoroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$mviKotlinVersion"

    //Coroutines
    private const val coroutinesVersion = "1.6.4"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"


    //Settings Data
    private const val settingsDataVersion = "1.0.0"
    const val settingsData = "com.russhwolf:multiplatform-settings:${Deps.settingsDataVersion}"
    const val settingsDataNoArg = "com.russhwolf:multiplatform-settings-no-arg:$settingsDataVersion"
    const val settingsDataStore = "com.russhwolf:multiplatform-settings-datastore:${Deps.settingsDataVersion}"

    //Koin
    const val koinVersion = "3.2.0"
    const val koinCore = "io.insert-koin:koin-core:${koinVersion}"
    const val koinTest = "io.insert-koin:koin-test:${koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${koinVersion}"
}