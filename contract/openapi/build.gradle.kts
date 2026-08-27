import io.github.skymaster.build.ContractType

plugins {
    id("skymaster.contract-holder")
}

contract {
    type.set(ContractType.OPENAPI)
    file.set(layout.projectDirectory.file("openapi.json"))
    tokens.set(
        mapOf(
            "version" to project.version.toString()
        )
    )
}