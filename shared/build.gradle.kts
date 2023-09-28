plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
    id("com.datadoghq.dd-sdk-android-gradle-plugin") version "1.11.0"
}

apply(from = "$rootDir/publish.gradle")

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    multiplatformSwiftPackage {
        swiftToolsVersion("5.3")
        targetPlatforms {
            iOS { v("13") }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.demo.kmmlibrary"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }

    dependencies {
        //DATA DOG RUM
        implementation("com.datadoghq:dd-sdk-android-rum:2.1.0@aar") {
            isTransitive = true
        }

        //DATA DOG WEBVIEW
        implementation("com.datadoghq:dd-sdk-android-webview:2.1.0") {
            isTransitive = true
        }

        //DATA DOG LOG
        implementation("com.datadoghq:dd-sdk-android-logs:2.1.0") {
            isTransitive = true
        }
    }
}