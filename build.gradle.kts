// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

}

plugins {
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.androidx.ksp)
    alias(libs.plugins.dagger.hilt) apply false
}