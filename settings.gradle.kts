pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
            mavenCentral()
            gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CounterApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":counter-data")
include(":counter-domain")
include(":feature-counter")
include(":core")
