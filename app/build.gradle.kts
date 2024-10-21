import dependencies.ConfigurationData

plugins {
    kotlin("kapt")
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mctable.fateproject"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        applicationId = ConfigurationData.applicationId
        minSdk = ConfigurationData.minSdk
        targetSdk = ConfigurationData.targetSdk
        versionCode = ConfigurationData.versionCode
        versionName = ConfigurationData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = ConfigurationData.jvmTarget
        languageVersion = ConfigurationData.kotlin
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    kapt(libs.hilt.kapt)
    implementation(project(mapOf("path" to ":core")))
    implementation(project(mapOf("path" to ":commons")))
    implementation(project(mapOf("path" to ":namodule")))
    implementation(libs.bundles.hilt.bundle)
    implementation(libs.bundles.core.bundle)
    implementation(libs.bundles.androidx.bundle)
    testImplementation(libs.bundles.unit.test.bundle)
    androidTestImplementation(libs.bundles.compose.ui.test.bundle)
    androidTestImplementation(platform(libs.compose.bom))
    debugImplementation(libs.bundles.debug.implementation.bundle)
}

kapt {
    correctErrorTypes = true
}