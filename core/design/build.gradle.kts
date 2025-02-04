plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.library.compose)
}

android {
    namespace = "com.example.core.design"
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.coil.network)
}