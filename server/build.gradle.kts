plugins {
    id("skymaster.java")
    id("skymaster.openapi-generator")
    alias(libs.plugins.org.springframework.boot)
    alias(libs.plugins.io.spring.dependency.management)
}

dependencies {
    implementation(libs.bundles.server.implementation)
    testImplementation(libs.bundles.server.testImplementation)
    testRuntimeOnly(libs.bundles.server.testRuntimeOnly)
}

openApiGenerate {
    generatorName.set("spring")

    apiPackage.set("io.github.skymaster.openapi.api")
    modelPackage.set("io.github.skymaster.openapi.model")

    configOptions.put("interfaceOnly", "true")
    configOptions.put("skipDefaultInterface", "true")
    configOptions.put("useSpringBoot4", "true")
    configOptions.put("useJspecify", "true")
    configOptions.put("useJackson3", "true")
    configOptions.put("useTags", "true")
    configOptions.put("openApiNullable", "false")
    configOptions.put("generateJsonIncludeAnnotations", "false")
    configOptions.put("generateJsonSetterNullsAnnotations", "false")

    globalProperties = mapOf(
        "apis" to "",
        "models" to "",
        "supportingFiles" to "false"
    )
}