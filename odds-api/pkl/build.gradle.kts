plugins {
    id("project.pkl")
}

customOpenApiGeneration {
    apiName.set("OddsApi")
    openApiProvenance.set("pkl")
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

tasks.named("build").configure {
    dependsOn("evalPkl")
}
