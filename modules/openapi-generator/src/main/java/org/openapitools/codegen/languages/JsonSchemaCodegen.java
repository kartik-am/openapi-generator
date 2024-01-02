package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openapitools.codegen.utils.StringUtils.camelize;

public class JsonSchemaCodegen extends DefaultCodegen implements CodegenConfig {
//    public static final String PROJECT_NAME = ;
    protected String packageName = "model";

    private final Logger LOGGER = LoggerFactory.getLogger(JsonSchemaCodegen.class);

    public CodegenType getTag() {
        return CodegenType.SCHEMA;
    }

    public String getName() {
        return "json-schema";
    }

    public String getHelp() {
        return "Generates a json-schema.";
    }

    public JsonSchemaCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "json-schema";
        modelTemplateFiles.put("model.mustache", ".json");
//        apiTemplateFiles.put("api.mustache", ".json");
        embeddedTemplateDir = templateDir = "json-schema";
//        apiPackage = "Apis";
        modelPackage = "models";
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));

        languageSpecificPrimitives = new HashSet<>(
                Arrays.asList("null", "boolean", "int", "integer", "long", "float", "double", "bytes", "string",
                        "BigDecimal", "UUID", "number", "date", "DateTime")
        );
        defaultIncludes = new HashSet<>(languageSpecificPrimitives);

        instantiationTypes.put("array", "Array");
        instantiationTypes.put("list", "Array");
        instantiationTypes.put("map", "Object");

        typeMapping.clear();
        typeMapping.put("number", "double");
        typeMapping.put("DateTime", "string");
        typeMapping.put("date", "string");
        typeMapping.put("short", "int");
        typeMapping.put("char", "string");
        typeMapping.put("integer", "int");
        typeMapping.put("array", "array");
        typeMapping.put("boolean", "boolean");
    }

    @Override
    protected void setNonArrayMapProperty(CodegenProperty property, String type) {
        super.setNonArrayMapProperty(property, type);
        if (property.isModel) {
            property.dataType = camelize(modelNamePrefix + property.dataType + modelNameSuffix);
        }
    }
}
