package io.github.skymaster.build

import org.gradle.api.attributes.Attribute

object ContractSchema {

    val CONTRACT_TYPE: Attribute<ContractType> = Attribute.of("io.github.skymaster.build.schema-type", ContractType::class.java)

}