
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(auth.Deps.kotlinGradlePlugin)
        classpath(auth.Deps.androidBuildTools)
        classpath(auth.Deps.sqlDelightGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}