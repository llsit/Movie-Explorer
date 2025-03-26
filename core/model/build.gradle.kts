plugins {
    alias(libs.plugins.common.android.library)
    alias(libs.plugins.ksp.gradlePlugin)
}

android {
    namespace = "com.example.core.model"
}

dependencies {
    api(libs.moshi)
    ksp(libs.moshi.codegen)
}
