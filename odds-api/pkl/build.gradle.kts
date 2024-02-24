plugins {
    alias(libs.plugins.pkl.plugin)
    id("project.smithy")
}

pkl {
    evaluators {
        register("evalPkl") {
            projectDir.set(file("src/main/pkl"))
            sourceModules.add(file("src/main/pkl/odds-api.pkl"))
            outputFile.set(layout.buildDirectory.file("openapi/OddsApi.openapi.yaml"))
        }
    }
}

customOpenApiGeneration {
    apiName.set("OddsApi")
    openApiProvenance.set("pkl")
}
