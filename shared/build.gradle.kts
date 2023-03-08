

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version auth.Versions.kotlinVersion
    id("com.squareup.sqldelight")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting{
            dependencies {
                implementation(auth.Deps.sqlDelightRuntime)
                implementation(auth.Deps.sqlDelightCoroutinesExtensions)

                //MVIKotlin
                implementation (auth.Deps.mviKotlin)
                implementation (auth.Deps.mviKotlinMain)
                implementation (auth.Deps.mviKotlinCoroutines)

                //Coroutines
                implementation (auth.Deps.coroutines)

                //Ktor
                implementation(auth.Deps.ktorCore)
                implementation(auth.Deps.ktorCio)
                implementation(auth.Deps.ktorAuth)
                implementation(auth.Deps.ktorSerialization)
                implementation(auth.Deps.ktorSerializationJson)


                //Multiplatform Settings
                implementation(auth.Deps.settingsData)

                //Settings Store
                implementation(auth.Deps.settingsDataStore)
                implementation(auth.Deps.settingsDataNoArg)
                implementation(auth.Deps.settingsData)

                //Koin
                implementation(auth.Deps.koinCore)
                implementation(auth.Deps.koinTest)


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))

            }
        }
        val androidMain by getting {
            dependencies {
                implementation(auth.Deps.ktorAndroid)
                implementation(auth.Deps.sqlDelightAndroidDriver)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation(auth.Deps.ktorIOS)
                implementation(auth.Deps.sqlDelightNativeDriver)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.kmm_auth_challenge"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
dependencies {
    implementation("androidx.datastore:datastore-core:1.0.0")
}
