package project

import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

plugins {
    id("java")
    id("software.amazon.smithy")
    id("org.openapi.generator")
}

apply<CustomOpenApiGenerationPlugin>()

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

sourceSets {
    main {
        java {
            srcDir("src/main/smithy")
        }
    }
}

dependencies {
    implementation(libs.smithy.cli)
    implementation(libs.smithy.model)
    implementation(libs.smithy.openapi)
    implementation(libs.smithy.aws.traits)
}
