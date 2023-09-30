package dependencies

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: String){
    add("implementation", dependency)
}

fun DependencyHandler.implementation(dependency: Dependency){
    add("implementation", dependency)
}

fun DependencyHandler.test(dependency: String){
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTest(dependency: String){
    add("androidTeste", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String){
    add("debugImplementation", dependency)
}

fun DependencyHandler.alow(dependency: String){
    add("kapt", dependency)
}