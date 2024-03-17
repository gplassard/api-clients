plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(libs.smithy.plugin)
    implementation(libs.openapi.plugin)
    implementation(libs.integrationtest.plugin)
    implementation(libs.pkl.plugin)
}
