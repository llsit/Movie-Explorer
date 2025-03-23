plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibraryComposeConventionPlugin") {
            id = "gradlePlugins.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationComposeConventionPlugin")  {
            id = "gradlePlugins.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplicationConventionPlugin") {
            id = "gradlePlugins.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryConventionPlugin") {
            id = "gradlePlugins.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHiltConventionPlugin") {
            id = "gradlePlugins.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidNetworkConventionPlugin") {
            id = "gradlePlugins.android.network"
            implementationClass = "AndroidNetworkConventionPlugin"
        }
        register("androidFeatureConventionPlugin") {
            id = "gradlePlugins.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}