import io.github.skymaster.build.ContractType

plugins {
    id("skymaster.contract-holder")
}

contract {
    type = ContractType.OPENAPI
    file = layout.projectDirectory.file("contract.json")
    tokens = mapOf("version" to project.version.toString())
}
