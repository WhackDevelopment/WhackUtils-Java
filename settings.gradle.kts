rootProject.name = "WhackUtils"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(":whack-utils-api")
include(":whack-utils-core")
project(":whack-utils-core").name = "WhackUtils"

include(":testing")
project(":testing").name = "WhackUtilsTests"
