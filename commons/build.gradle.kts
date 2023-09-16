import dependencies.ConfigurationData
import dependencies.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.mctable.commons"
    compileSdk = ConfigurationData.compileSdk

    defaultConfig {
        minSdk = ConfigurationData.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(Libs.AndroidX.Compose.composeBom))
    implementation(Libs.AndroidX.Compose.composeUi)
    implementation(Libs.AndroidX.Compose.composeGraphics)
    implementation(Libs.AndroidX.Compose.composePreview)
    implementation(Libs.AndroidX.material3)
    implementation(Libs.AndroidX.androidCore)
    implementation(Libs.AndroidX.androidLifeCycle)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.Google.material)
    implementation(Libs.AndroidX.Compose.composeActivity)
    testImplementation(Libs.UnitTests.junit)
    testImplementation(Libs.UnitTests.mockk)
    testImplementation(Libs.UnitTests.webServer)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}