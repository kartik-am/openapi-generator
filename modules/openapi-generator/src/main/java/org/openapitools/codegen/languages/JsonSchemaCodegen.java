package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSchemaCodegen extends DefaultCodegen implements CodegenConfig {
//    public static final String PROJECT_NAME = ;
    protected String packageName = "model";

    private final Logger LOGGER = LoggerFactory.getLogger(JsonSchemaCodegen.class);

    @Override
    public CodegenType getTag() {
        return CodegenType.SCHEMA;
    }

    @Override
    public String getName() {
        return "json-schema";
    }

    @Override
    public String getHelp() {
        return "Generates a json-schema schema.";
    }

    
    public JsonSchemaCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "json-schema";
        modelTemplateFiles.put("model.mustache", ".json");
//        apiTemplateFiles.put("api.mustache", ".json");
        embeddedTemplateDir = templateDir = "json-schema";
//        apiPackage = "Apis";
        modelPackage = "Models";
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
    }
}
