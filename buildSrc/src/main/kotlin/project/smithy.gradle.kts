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
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/gplassard/api-clients")
        credentials {
            username = (project.findProperty("gpr.user") as? String) ?: System.getenv("GITHUB_ACTOR")
            password = (project.findProperty("gpr.key") as? String) ?: System.getenv("GITHUB_TOKEN")
        }
    }
    val codeartifactUrl = project.findProperty("codeartifact.url")?.toString() ?: System.getenv("CODE_ARTIFACT_URL")
    if (codeartifactUrl != null) {
        maven {
            name = "CodeArtifact"
            url = uri(project.findProperty("codeartifact.url")?.toString() ?: System.getenv("CODE_ARTIFACT_URL"))
            credentials {
                username = "aws"
                password = project.findProperty("codeartifact.token")?.toString() ?: System.getenv("CODEARTIFACT_AUTH_TOKEN")
            }
        }
    }
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
    implementation(libs.smithy.extensions.openapi)
    implementation(libs.smithy.cli)
    implementation(libs.smithy.model)
    implementation(libs.smithy.openapi)
    implementation(libs.smithy.aws.traits)
}
