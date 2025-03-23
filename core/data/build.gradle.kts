plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.common.android.hilt)
    alias(libs.plugins.common.android.network)
}

android {
    namespace = "com.example.core.data"
}

dependencies {

    implementation(projects.core.network)
    api(projects.core.common)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}