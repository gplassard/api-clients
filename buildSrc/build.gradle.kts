plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    fun pluginDependency(id: String, version: String) {
        implementation("$id:$id.gradle.plugin:$version")
    }

    pluginDependency("software.amazon.smithy", "0.7.0")
    pluginDependency("org.openapi.generator", "7.0.1")
}
