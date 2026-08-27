import io.github.skymaster.build.ContractHolderExtension
import io.github.skymaster.build.ContractSchema

val contract = extensions.create<ContractHolderExtension>("contract")

val processContract = tasks.register<Sync>("processContract") {
    group = LifecycleBasePlugin.BUILD_GROUP
    description = "Processes the contract and expands tokens"

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

configurations.create("processedContract") {
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes {
        attributeProvider(ContractSchema.CONTRACT_TYPE, contract.type)
    }
    outgoing.artifact(processedContract) {
        builtBy(processContract)
    }
}