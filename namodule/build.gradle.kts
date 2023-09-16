import dependencies.ConfigurationData
import dependencies.Libs
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mctable.namodule"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    //Hilt
    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)
    implementation(Libs.Hilt.hiltNavigation)

    //Coroutines
    implementation(Libs.Coroutines.coroutines)

    implementation(platform(Libs.AndroidX.Compose.composeBom))
    implementation(Libs.Core.arrow)
    implementation(Libs.AndroidX.Compose.composeUi)
    implementation(Libs.AndroidX.Compose.composeGraphics)
    implementation(Libs.AndroidX.Compose.composePreview)
    implementation(Libs.AndroidX.material3)
    implementation(Libs.AndroidX.androidCore)
    implementation(Libs.Networking.retrofit)
    implementation(Libs.Networking.retrofitGsonConverter)
    implementation(Libs.Networking.gson)
    implementation(Libs.AndroidX.androidLifeCycle)
    //Modules
    implementation(project(Libs.Modules.commons))
    implementation(project(Libs.Modules.core))
    implementation(Libs.AndroidX.Compose.composeActivity)
    //Compose navigation
    implementation(Libs.AndroidX.Compose.composeNavigation)
    testImplementation(Libs.UnitTests.junit)
    testImplementation(Libs.UnitTests.mockk)
    testImplementation(Libs.UnitTests.webServer)
    testImplementation(Libs.UnitTests.coroutines)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}