plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.smithy.model)
    implementation(libs.smithy.openapi)
}
