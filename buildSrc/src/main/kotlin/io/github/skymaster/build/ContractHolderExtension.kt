package io.github.skymaster.build

import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property

interface ContractHolderExtension {

    val type: Property<ContractType>

    val file: RegularFileProperty

    val tokens: MapProperty<String, String>

}
