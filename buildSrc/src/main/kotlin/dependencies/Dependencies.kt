package dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val COMPOSE = "1.7.2"
    const val ANDROID_CORE = "1.10.1"
    const val LIFE_CYCLE = "2.6.1"
    const val HILT = "2.44"
    const val HILT_NAVIGATION = "1.0.0"
    const val RETROFIT = "2.9.0"
    const val RETROFIT_GSON = "2.3.0"
    const val LOGGING_INTERCEPTOR = "4.11.0"
    const val COMPOSE_NAVIGATION = "2.6.0"
    const val COROUTINES = "1.6.4"
    const val APP_COMPAT = "1.6.1"
    const val GSON = "2.8.9"
    const val KOTLIN = "1.7.0"
    const val GRADLE = "7.2.1"
    const val ARROW = "1.2.0"
    const val COIL = "2.4.0"
    const val MOCKK = "1.13.7"
    const val MOCK_WEB_SERVER = "4.11.0"
    const val JUNIT = "4.13.2"
    const val MATERIAL = "1.9.0"
    const val COROUTINES_TEST = "1.7.3"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.GRADLE}"

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    }

    object Core {
        const val arrow = "io.arrow-kt:arrow-core:${Versions.ARROW}"
        const val coil = "io.coil-kt:coil-compose:${Versions.COIL}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object AndroidX {
        const val androidCore = "androidx.core:core-ktx:${Versions.ANDROID_CORE}"
        const val androidLifeCycle =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFE_CYCLE}"
        const val material3 = "androidx.compose.material3:material3"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

        object Compose {
            const val composeActivity = "androidx.activity:activity-compose:${Versions.COMPOSE}"
            const val composeNavigation =
                "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
            const val composeUi = "androidx.compose.ui:ui"
            const val composeGraphics = "androidx.compose.ui:ui-graphics"
            const val composePreview = "androidx.compose.ui:ui-tooling-preview"
            const val composeBom = "androidx.compose:compose-bom:2023.03.00"
            const val composePreviewDebug = "androidx.compose.ui:ui-tooling"
        }
    }

    object Modules {
        val commons = mapOf("path" to ":commons")
        val core = mapOf("path" to ":core")
        val naModule = mapOf("path" to ":namodule")
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val hiltNavigation =
            "androidx.hilt:hilt-navigation-fragment:${Versions.HILT_NAVIGATION}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val gson = "com.google.code.gson:gson:${Versions.GSON}"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_GSON}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"
    }

    object Coroutines {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }

    object UnitTests {
        const val mockk = "io.mockk:mockk:${Versions.MOCKK}"
        const val webServer = "com.squareup.okhttp3:mockwebserver:${Versions.MOCK_WEB_SERVER}"
        const val junit = "junit:junit:${Versions.JUNIT}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_TEST}"
    }
}

fun DependencyHandler.networking(){
    implementation(Libs.Networking.retrofit)
    implementation(Libs.Networking.retrofitGsonConverter)
    implementation(Libs.Networking.loggingInterceptor)
    implementation(Libs.Networking.gson)
}

fun DependencyHandler.hilt(){
    implementation(Libs.Hilt.hilt)
    alow(Libs.Hilt.hiltKapt)
    implementation(Libs.Hilt.hiltNavigation)
}

fun DependencyHandler.core(){
    implementation(Libs.Coroutines.coroutines)
    implementation(Libs.Core.arrow)
    implementation(Libs.Core.coil)
}

fun DependencyHandler.unitTests(){
    test(Libs.UnitTests.junit)
    test(Libs.UnitTests.mockk)
    test(Libs.UnitTests.webServer)
    implementation(Libs.UnitTests.webServer)
    test(Libs.UnitTests.coroutines)
    test(Libs.UnitTests.coroutinesCore)
}

fun DependencyHandler.google(){
    implementation(Libs.Google.material)
}

fun DependencyHandler.androidX(){
    implementation(Libs.AndroidX.Compose.composeUi)
    implementation(Libs.AndroidX.Compose.composeGraphics)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.Compose.composePreview)
    implementation(Libs.AndroidX.material3)
    implementation(Libs.AndroidX.androidCore)
    implementation(Libs.AndroidX.Compose.composeActivity)
    implementation(Libs.AndroidX.androidLifeCycle)
    implementation(Libs.AndroidX.Compose.composeNavigation)
    implementation(platform(Libs.AndroidX.Compose.composeBom))
    debugImplementation(Libs.AndroidX.Compose.composePreviewDebug)
}

fun DependencyHandler.coreModule(){
    implementation(project(Libs.Modules.core))
}

fun DependencyHandler.naModule(){
    implementation(project(Libs.Modules.naModule))
}

fun DependencyHandler.commonsModule(){
    implementation(project(Libs.Modules.commons))
}