plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.hilt)
}

android {
    namespace = "com.example.core.domain"
}

dependencies {
    implementation(projects.core.data)
}