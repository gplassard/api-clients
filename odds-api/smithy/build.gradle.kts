plugins {
    id("project.smithy")
}

customOpenApiGeneration {
    apiName.set("OddsApi")
    openApiProvenance.set("smithy")
}
