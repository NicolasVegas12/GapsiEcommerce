plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.ksp)
}
apply<MainGradlePlugin>()

android {
    namespace = ModulesConfig.domainNamespace

    buildTypes {



    }

}

dependencies {

    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.bundles.dagger.hilt.compose)
    ksp(libs.bundles.dagger.hilt.compiler)

    implementation(libs.bundles.serialization)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}