plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "skymaster"

include("contract:openapi")

include("app", "list", "utilities")
