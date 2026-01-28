pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "docdefaut"
include(":app")
include(":test")
include(":modules:authentication")
include(":modules:test")
project(":modules:authentication").projectDir = file("modules/authentication")
project(":modules:test").projectDir = file("modules/test")
include("modules:common")
