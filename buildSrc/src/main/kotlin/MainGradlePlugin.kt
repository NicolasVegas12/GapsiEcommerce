import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class MainGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project)
        setProjectConfig(project)

    }


    private fun applyPlugins(project: Project) {
        project.apply {
            plugin("kotlin-parcelize")
            plugin("org.jetbrains.kotlin.plugin.serialization")
        }
    }



    private fun setProjectConfig(project: Project) {
        when (val androidExtension = project.extensions.findByName("android")) {
            is LibraryExtension -> configureLibrary(androidExtension)
            is AppExtension -> configureApp(androidExtension)
            else -> project.logger.warn("Este plugin solo soporta proyectos Android (App o Library).")
        }


        project.extensions.findByName("kotlin")?.let { kotlinExtension ->
            if (kotlinExtension is KotlinProjectExtension) {
                kotlinExtension.jvmToolchain(21)
            }
        }

    }


    private fun configureLibrary(libraryExtension: LibraryExtension) {
        libraryExtension.apply {

            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "com.ivy.common.androidtest.HiltTestRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }



            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

            buildFeatures {
                buildConfig = true
            }

        }
    }

    private fun configureApp(appExtension: AppExtension) {
        appExtension.apply {
            compileSdkVersion(ProjectConfig.compileSdk)
            buildFeatures.buildConfig = true

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                targetSdk = ProjectConfig.targetSdk
                testInstrumentationRunner = "com.ivy.common.androidtest.HiltTestRunner"
            }

            buildTypes {
                named("release") {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

        }
    }
}