plugins {
    id("skymaster.java")
    alias(libs.plugins.org.springframework.boot)
    alias(libs.plugins.io.spring.dependency.management)
}

dependencies {
    implementation(libs.bundles.server.implementation)
    testImplementation(libs.bundles.server.testImplementation)
    testRuntimeOnly(libs.bundles.server.testRuntimeOnly)
}