plugins {
    id("java")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}