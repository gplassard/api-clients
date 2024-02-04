package fr.gplassard.apiclients.plugins.openapi;

import fr.gplassard.apiclients.plugins.openapi.mappers.OpenApiTypeMapper;
import software.amazon.smithy.jsonschema.JsonSchemaMapper;
import software.amazon.smithy.openapi.fromsmithy.Smithy2OpenApiExtension;

import java.util.List;

public class Smithy2OpenApiPlugin implements Smithy2OpenApiExtension {
    @Override
    public List<JsonSchemaMapper> getJsonSchemaMappers() {
        return List.of(
                new OpenApiTypeMapper()
        );
    }
}
