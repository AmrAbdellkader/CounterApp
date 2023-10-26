import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}
group = "com.google.samples.apps.counterApp.buildlogic"


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {

        register("androidApplication") {
            id = "counterApp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }

}