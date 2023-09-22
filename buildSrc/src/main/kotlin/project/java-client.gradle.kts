package project

import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

plugins {
    id("java")
    id("maven-publish")
    id("com.coditory.integration-test")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.datatype.jsr310)
    implementation(libs.jackson.databind.nullable)
    implementation(libs.jakarta.annotation.api)

    testImplementation(libs.junit)
    testImplementation(libs.assertj)
    testRuntimeOnly(libs.junit.platform)
}

tasks.withType<Test> {
    useJUnitPlatform()
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
    }
    publications {
        create<MavenPublication>("maven") {
            val baseModule = project.path.split(":")[1]

            groupId = "fr.gplassard.apiclients"
            artifactId = baseModule
            from(components["java"])
        }
    }
}

tasks.named("compileJava") {
    project.parent?.getTasksByName("codegenJavaClient", true)?.forEach {
        dependsOn(it)
    }
}
