import io.github.skymaster.build.ContractSchema
import io.github.skymaster.build.ContractType

plugins {
    id("skymaster.java-library")
    id("org.openapi.generator")
}

val openApiSchema = configurations.create("openApiSchema") {
    isCanBeResolved = true
    isCanBeConsumed = false
    attributes {
        attribute(ContractSchema.CONTRACT_TYPE, ContractType.OPENAPI)
    }
}

dependencies {
    openApiSchema(project(":contract:openapi"))
}

val schemaFile = layout.file(openApiSchema.elements.map { it.single().asFile })

val generatedRoot = layout.buildDirectory.dir("generated-sources/openapi")

openApiValidate {
    inputSpec.set(schemaFile)
}

openApiGenerate {
    inputSpec.set(schemaFile)
    outputDir.set(generatedRoot)
    quiet.set(true)
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}

tasks.openApiGenerate {
    dependsOn(tasks.openApiValidate)
}

sourceSets {
    main {
        java.srcDir(generatedRoot)
    }
}