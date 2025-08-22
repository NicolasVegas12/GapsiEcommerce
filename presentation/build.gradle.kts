plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.ksp)
}
apply<MainGradlePlugin>()

android {
    namespace = ModulesConfig.presentationNamespace

    buildTypes {



    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":common"))

    //Compose
    implementation(libs.bundles.android.compose.core)
    implementation(libs.bundles.android.compose.extensions)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.bundles.serialization)

    implementation(libs.bundles.dagger.hilt.compose)
    ksp(libs.bundles.dagger.hilt.compiler)

    implementation(libs.google.swipe.refresh)
    implementation(libs.bundles.paging)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}