plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.ksp)
    alias(libs.plugins.room)
}
apply<MainGradlePlugin>()

android {
    namespace = ModulesConfig.dataNamespace

    buildTypes {



    }

}

room {
    schemaDirectory("schemas")
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.bundles.dagger.hilt.compose)
    ksp(libs.bundles.dagger.hilt.compiler)

    implementation(libs.bundles.retrofit)
    implementation(platform(libs.retrofit.pom))

    implementation(libs.bundles.serialization)

    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}