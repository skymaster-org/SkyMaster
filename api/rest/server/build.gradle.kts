plugins {
    id("skymaster.openapi-generator")
}

dependencies {
    implementation(platform(libs.spring.boot.dependencies))
    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.springdoc.openapi.starter.webmvc.ui)
    testImplementation(libs.spring.boot.starter.webmvc.test)
    testImplementation(libs.spring.boot.starter.validation.test)
}

openApiGenerate {
    generatorName.set("spring")

    apiPackage.set("io.github.skymaster.openapi.api")
    modelPackage.set("io.github.skymaster.openapi.model")

    configOptions.putAll(
        mapOf(
            "interfaceOnly" to "true",
            "skipDefaultInterface" to "true",
            "useSpringBoot4" to "true",
            "useTags" to "true",
            "openApiNullable" to "false",
            "useJspecify" to "true",
            "sourceFolder" to "",
            "useJackson3" to "true",
            "generateJsonIncludeAnnotations" to "true",
            "generateJsonSetterNullsAnnotations" to "false",
        )
    )

    globalProperties.putAll(
        mapOf(
            "apis" to "",
            "models" to "",
            "supportingFiles" to "false"
        )
    )
}