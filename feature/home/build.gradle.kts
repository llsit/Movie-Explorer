plugins {
    alias(libs.plugins.common.android.library.compose)
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.hilt)
}

android {
    namespace = "com.example.feature.home"
}