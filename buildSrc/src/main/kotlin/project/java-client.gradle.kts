package project

plugins {
    id("java")
}

repositories {
    mavenCentral()
}

val jackson_version = "2.15.2"
val jakarta_annotation_version = "2.1.1"
val openapitools_jackson_databind_nullable_version = "0.2.6"

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:$jackson_version")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson_version")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson_version")
    implementation("org.openapitools:jackson-databind-nullable:$openapitools_jackson_databind_nullable_version")
    implementation("jakarta.annotation:jakarta.annotation-api:$jakarta_annotation_version")
}

tasks.named("compileJava") {
    project.parent?.getTasksByName("codegenJavaClient", true)?.forEach {
        dependsOn(it)
    }
}
