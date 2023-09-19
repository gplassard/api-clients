package project

plugins {
    id("java")
    id("software.amazon.smithy")
    id("org.openapi.generator")
}

repositories {
    mavenCentral()
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

sourceSets {
    main {
        java {
            include("src/main/smithy")
        }
    }
}

dependencies {
    implementation("software.amazon.smithy:smithy-cli:1.38.0")
    implementation("software.amazon.smithy:smithy-model:1.38.0")
    implementation("software.amazon.smithy:smithy-openapi:1.38.0")
    implementation("software.amazon.smithy:smithy-aws-traits:1.38.0")
}
