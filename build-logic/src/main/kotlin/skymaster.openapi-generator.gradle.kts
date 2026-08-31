import gradle.kotlin.dsl.accessors._231530f1a807ec2618b6672dff9201b2.compileJava
import gradle.kotlin.dsl.accessors._231530f1a807ec2618b6672dff9201b2.sourceSets
import io.github.skymaster.build.ContractSchema
import io.github.skymaster.build.ContractType

plugins {
    id("skymaster.java")
    id("org.openapi.generator")
}

val openApiContract = configurations.create("openapiSchema") {
    isCanBeResolved = true
    isCanBeConsumed = false
    attributes {
        attribute(ContractSchema.CONTRACT_TYPE, ContractType.OPENAPI)
    }
}

dependencies {
    openApiContract(project(":contract:openapi"))
}

val contractFile = layout.file(openApiContract.elements.map { it.single().asFile })

openApiValidate {
    inputSpec.set(contractFile)
}

val generatedRoot = layout.buildDirectory.dir("generated-sources/openapi")

openApiGenerate {
    inputSpec.set(contractFile)
    quiet.set(true)

    outputDir.set(generatedRoot)

    configOptions.put("sourceFolder", "")
}

tasks.openApiGenerate {
    dependsOn(tasks.openApiValidate)
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}

sourceSets {
    main {
        java.srcDir(generatedRoot)
    }
}