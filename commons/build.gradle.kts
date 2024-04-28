import dependencies.ConfigurationData

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
    implementation(libs.bundles.androidx.bundle)
    implementation(libs.bundles.material.bundle)
    testImplementation(libs.bundles.unit.test.bundle)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}