plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.hilt)
    alias(libs.plugins.common.android.network)
}

android {
    namespace = "com.example.core.network"
}

dependencies {
    api(libs.moshi)
}