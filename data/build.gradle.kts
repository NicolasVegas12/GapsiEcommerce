import java.io.FileInputStream
import java.util.Properties

plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.androidx.ksp)
    alias(libs.plugins.room)
}
apply<MainGradlePlugin>()

val serverFile = rootProject.file("server.properties")
val serverProps = Properties()
serverProps.load(FileInputStream(serverFile))
val SERVER_URL = '"' + serverProps["SERVER_URL"] as String + '"'



val keystoreFile = rootProject.file("keystore.properties")
val keystoreProps = Properties()
keystoreProps.load(FileInputStream(keystoreFile))
val API_SECRET = '"' + keystoreProps["API_SECRET_KEY"] as String+ '"'

android {
    namespace = ModulesConfig.dataNamespace

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", SERVER_URL)
            buildConfigField("String", "API_SECRET_KEY", API_SECRET)

        }


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