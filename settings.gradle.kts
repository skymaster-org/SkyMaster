rootProject.name = "skymaster"

pluginManagement {
    includeBuild("build-logic")
}

include("api:rest-client")
include("api:rest-server")
include("contract:openapi")
include("server:boot")
include("server:rest")
include("mod:core")
include("mod:fabric")