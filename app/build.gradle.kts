
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mctable.fateproject"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mctable.fateproject"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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

val composeVersion = "1.7.2"
val androidCoreVersion = "1.10.1"
val lifeCycleVersion = "2.6.1"
val hiltVersion = "2.44"
val retrofitVersion = "2.9.0"
val composeNavVersion = "2.6.0"
val coroutinesVersion = "1.6.4"

dependencies {

    implementation("androidx.core:core-ktx:$androidCoreVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleVersion")
    implementation("androidx.activity:activity-compose:$composeVersion")

    //Compose navigation
    implementation("androidx.navigation:navigation-compose:$composeNavVersion")

    //Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation(project(mapOf("path" to ":commons")))
    implementation(project(mapOf("path" to ":core")))
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
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