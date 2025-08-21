plugins {
    id("com.android.application")
    `kotlin-android`
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.ksp)
}

apply<MainGradlePlugin>()

android {
    namespace = ModulesConfig.appNamespace
    compileSdk = 36

    defaultConfig {

        applicationId = ProjectConfig.appId
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":common"))

    //hilt
    implementation(libs.bundles.dagger.hilt.compose)
    ksp(libs.bundles.dagger.hilt.compiler)


    implementation(libs.bundles.serialization)


    //Compose
    implementation(libs.bundles.android.compose.core)
    implementation(libs.bundles.android.compose.extensions)
    implementation(platform(libs.androidx.compose.bom))


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}