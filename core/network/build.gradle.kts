plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.hilt)
}

android {
    namespace = "com.example.core.network"
}

dependencies {
    implementation(libs.retrofit)
    api(libs.moshi)
    implementation(libs.retrofit.moshi)
}