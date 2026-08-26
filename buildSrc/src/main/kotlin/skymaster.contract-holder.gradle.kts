import io.github.skymaster.build.ContractHolderExtension
import io.github.skymaster.build.ContractSchema

val contract: ContractHolderExtension = extensions.create<ContractHolderExtension>("contract")

val processContract = tasks.register<Sync>("processContract") {
    description = "Prepares the contract for consumption"
    group = "build"

    val tokens = contract.tokens
    inputs.property("tokens", tokens)
    filteringCharset = "UTF-8"

    from(contract.file) {
        val values = tokens.get()
        if (values.isNotEmpty()) {
            filter { line ->
                values.entries.fold(line) { acc, (key, value) -> acc.replace("@$key@", value) }
            }
        }
    }
    into(layout.buildDirectory.dir("contract"))
}

val processedContract = layout.buildDirectory.file(contract.file.map { "contract/${it.asFile.name}" })

configurations.create("schema") {
    isCanBeConsumed = true
    isCanBeResolved = false

    attributes {
        attributeProvider(ContractSchema.CONTRACT_TYPE, contract.type)
    }

    outgoing.artifact(processedContract) {
        builtBy(processContract)
    }
}