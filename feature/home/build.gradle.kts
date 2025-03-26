plugins {
    alias(libs.plugins.common.android.feature)
}

android {
    namespace = "com.example.feature.home"
}

dependencies {
    implementation(projects.core.model)
}