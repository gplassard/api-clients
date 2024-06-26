package project

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.register
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

interface CustomOpenApiGenerationPluginExtension {
    val apiName: Property<String>
}

class CustomOpenApiGenerationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create<CustomOpenApiGenerationPluginExtension>("customOpenApiGeneration")
        project.tasks.register<GenerateTask>("codegenJavaClient") {
            dependsOn("smithyBuildJar")

            val baseModule = project.path.split(":")[1]
            val packageName = baseModule.replace("-", "")
            val openApiLocation =  "smithy/build/smithyprojections/smithy/source/openapi/${extension.apiName.get()}.openapi.json"

            generatorName.set("java")
            inputSpec.set("${project.rootDir}/${baseModule}/${openApiLocation}")
            outputDir.set("${project.rootDir}/${baseModule}/java-client")
            configOptions.putAll(mapOf(
                "library" to "native",
                "useJakartaEe" to "true",
                "useRuntimeException" to "true",
                "groupId" to "fr.gplassard.apiclients",
                "artifactId" to "${baseModule}-api-client",
                "invokerPackage" to "fr.gplassard.apiclients.$packageName.javaclient",
                "apiPackage" to "fr.gplassard.apiclients.$packageName.javaclient.api.base",
                "modelPackage" to "fr.gplassard.apiclients.$packageName.javaclient.model",
            ))
        }

        project.tasks.register("codegen") {
            dependsOn("codegenJavaClient")
        }
    }
}
