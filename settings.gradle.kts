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

rootProject.name = "TryTestApplication"
include(":app")
include(":news:news_data")
include(":news:news_domain")
include(":news:news_presentation")
include(":search:search_data")
include(":search:search_domain")
include(":search:search_presentation")
include(":common:common_utils")
