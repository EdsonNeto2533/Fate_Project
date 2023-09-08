package dependencies

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
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.1"
    //...

    object Kotlin {
        private const val version = "1.7.0"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        //...
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
        }
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:${Versions.HILT_NAVIGATION}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val gson = "com.google.code.gson:gson:${Versions.GSON}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_GSON}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"
    }

    object Coroutines {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }
}