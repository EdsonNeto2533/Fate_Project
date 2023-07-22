package dependencies

object Versions {
    const val COMPOSE = "1.7.2"
    const val ANDROID_CORE = "1.10.1"
    const val LIFE_CYCLE = "2.6.1"
    const val HILT = "2.44"
    const val RETROFIT = "2.9.0"
    const val COMPOSE_NAVIGATION = "2.6.0"
    const val COROUTINES = "1.6.4"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.2.1"
    //...

    object Compose {

    }

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
        //...

        object Compose {
            const val composeActivity = "androidx.activity:activity-compose:${Versions.COMPOSE}"
            const val composeNavigation =
                "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
            const val composeUi = "androidx.compose.ui:ui"
            const val composeGraphics = "androidx.compose.ui:ui-graphics"
            const val composePreview = "androidx.compose.ui:ui-tooling-preview"
        }
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.HILT}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    }

    object Coroutines {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }
}