import dependencies.ConfigurationData
import dependencies.Libs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
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

    implementation(Libs.AndroidX.androidCore)
    implementation(Libs.AndroidX.androidLifeCycle)
    implementation(Libs.AndroidX.Compose.composeActivity)


    //Modules
    implementation(project(Libs.Modules.commons))
    implementation(project(Libs.Modules.core))
    implementation(project(Libs.Modules.naModule))

    //Compose navigation
    implementation(Libs.AndroidX.Compose.composeNavigation)

    //Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

    //Coroutines
    implementation(Libs.Coroutines.coroutines)

    implementation(platform(Libs.AndroidX.Compose.composeBom))
    implementation(Libs.AndroidX.Compose.composeUi)
    implementation(Libs.AndroidX.Compose.composeGraphics)
    implementation(Libs.AndroidX.Compose.composePreview)
    implementation(Libs.AndroidX.material3)
    testImplementation(Libs.UnitTests.junit)
    testImplementation(Libs.UnitTests.mockk)
    testImplementation(Libs.UnitTests.webServer)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true
}