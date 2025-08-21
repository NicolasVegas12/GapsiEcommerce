plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.androidx.ksp)
    alias(libs.plugins.dagger.hilt)
}
apply<MainGradlePlugin>()
android {
    namespace = ModulesConfig.commonNamespace

    buildTypes {



    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    //Compose
    implementation(libs.bundles.android.compose.core)
    implementation(libs.bundles.android.compose.extensions)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.bundles.dagger.hilt.compose)
    ksp(libs.bundles.dagger.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}