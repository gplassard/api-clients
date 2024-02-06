package project

import org.gradle.accessors.dm.LibrariesForLibs
import java.util.*

val libs = the<LibrariesForLibs>()

plugins {
    id("java")
    id("maven-publish")
}

val props = Properties().apply {
    load(project.parent?.file("gradle.properties")?.inputStream())
}
version = props.getProperty("version")

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.datatype.jsr310)
    implementation(libs.jackson.databind.nullable)
    implementation(libs.jakarta.annotation.api)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/gplassard/api-clients")
            credentials {
                username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key")?.toString() ?: System.getenv("GITHUB_TOKEN")
            }
        }
        val codeartifactUrl = project.findProperty("codeartifact.url")?.toString() ?: System.getenv("CODE_ARTIFACT_URL")
        if (codeartifactUrl != null) {
            maven {
                name = "CodeArtifact"
                url = uri(codeartifactUrl)
                credentials {
                    username = "aws"
                    password = project.findProperty("codeartifact.token")?.toString() ?: System.getenv("CODEARTIFACT_AUTH_TOKEN")
                }
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            val baseModule = project.path.split(":")[1]

            groupId = "fr.gplassard.apiclients"
            artifactId = "$baseModule-client"
            from(components["java"])
        }
    }
}

tasks.named("compileJava") {
    project.parent?.getTasksByName("codegenJavaClient", true)?.forEach {
        dependsOn(it)
    }
}
