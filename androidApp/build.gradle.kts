import auth.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    kotlin("plugin.serialization") version auth.Versions.kotlinVersion
}

android {
    namespace = "com.example.kmm_auth_challenge.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kmm_auth_challenge.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(auth.Deps.composeUi)
    implementation(auth.Deps.composeUiTooling)
    implementation(auth.Deps.composeUiToolingPreview)
    implementation(auth.Deps.composeFoundation)
    implementation(auth.Deps.composeMaterial)
    implementation(auth.Deps.activityCompose)
    implementation(auth.Deps.composeIconsExtended)
    implementation(auth.Deps.composeNavigation)
    implementation(auth.Deps.coilCompose)

    //Coroutines
    implementation(auth.Deps.coroutines)

    //Ktor
    implementation(auth.Deps.ktorAndroid)
    implementation(auth.Deps.ktorOkHttp)

    //MVIKotlin
    implementation (auth.Deps.mviKotlin)
    implementation (auth.Deps.mviKotlinMain)
    implementation (auth.Deps.mviKotlinCoroutines)


}