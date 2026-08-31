plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies{
    implementation(libs.org.openapi.generator.gradle.plugin)
}