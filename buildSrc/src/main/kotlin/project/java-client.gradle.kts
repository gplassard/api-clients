package project

import org.gradle.accessors.dm.LibrariesForLibs

val libs = the<LibrariesForLibs>()

plugins {
    id("java")
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
}

tasks.named("compileJava") {
    project.parent?.getTasksByName("codegenJavaClient", true)?.forEach {
        dependsOn(it)
    }
}
