package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import org.openapitools.codegen.meta.GeneratorMetadata;
import org.openapitools.codegen.meta.Stability;
import org.openapitools.codegen.meta.features.ClientModificationFeature;
import org.openapitools.codegen.meta.features.DocumentationFeature;
import org.openapitools.codegen.meta.features.GlobalFeature;
import org.openapitools.codegen.meta.features.ParameterFeature;
import org.openapitools.codegen.meta.features.SchemaSupportFeature;
import org.openapitools.codegen.meta.features.SecurityFeature;
import org.openapitools.codegen.meta.features.WireFormatFeature;
import org.openapitools.codegen.model.ModelsMap;

import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;

import static org.openapitools.codegen.utils.StringUtils.camelize;

import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Avro2TestSchemaCodegen extends DefaultCodegen implements CodegenConfig {
    
	private static final String AVRO = "avro2-test";
    protected String packageName = "model";

    private final Logger LOGGER = LoggerFactory.getLogger(Avro2TestSchemaCodegen.class);

    public CodegenType getTag() {
        return CodegenType.SCHEMA;
    }

    public String getName() {
        return "avro2-test";
    }

    public String getHelp() {
        return "Generates a json schema.";
    }

    public Avro2TestSchemaCodegen() {
        super();

        generatorMetadata = GeneratorMetadata.newBuilder(generatorMetadata)
                .stability(Stability.BETA)
                .build();

        // TODO: Avro maintainer review.
        modifyFeatureSet(features -> features
                .parameterFeatures(EnumSet.noneOf(ParameterFeature.class))
                .securityFeatures(EnumSet.noneOf(SecurityFeature.class))
                .wireFormatFeatures(EnumSet.noneOf(WireFormatFeature.class))
                .documentationFeatures(EnumSet.noneOf(DocumentationFeature.class))
                .globalFeatures(EnumSet.noneOf(GlobalFeature.class))
                .excludeSchemaSupportFeatures(
                        SchemaSupportFeature.Polymorphism,
                        SchemaSupportFeature.Union
                )
                .clientModificationFeatures(EnumSet.noneOf(ClientModificationFeature.class))
        );
        
        
        
        outputFolder = "generated-code" + File.separator + "avro2-test";
        modelTemplateFiles.put("model.mustache", ".json");
//        apiTemplateFiles.put("api.mustache", ".avsc");
        modelPackage = packageName;
        importMapping.clear();
        embeddedTemplateDir = templateDir = AVRO;

//        apiPackage = "apis";
        modelPackage = "models";
//        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        // TODO: Fill this out.
        
        hideGenerationTimestamp = Boolean.TRUE;

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
        typeMapping.put("ByteArray", "bytes");
        typeMapping.put("binary", "File");
        typeMapping.put("file", "File");
        typeMapping.put("UUID", "string");
        typeMapping.put("BigDecimal", "string");

        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_NAME, CodegenConstants.PACKAGE_NAME_DESC));
    }

    @Override
    public void processOpts() {
        super.processOpts();
        if (additionalProperties.containsKey(CodegenConstants.PACKAGE_NAME)) {
            packageName = (String) additionalProperties.get(CodegenConstants.PACKAGE_NAME);

            // Force the model package to the package name so import can be fully qualified
            modelPackage = packageName;
        }

        additionalProperties.put("packageName", packageName);
    }
    
    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator;
    }

    @Override
    public ModelsMap postProcessModels(ModelsMap objs) {
        return postProcessModelsEnum(objs);
    }

    @Override
    protected void setNonArrayMapProperty(CodegenProperty property, String type) {
        super.setNonArrayMapProperty(property, type);
        if (property.isModel) {
            property.dataType = camelize(modelNamePrefix + property.dataType + modelNameSuffix);
        }
    }

    @Override
    public String escapeUnsafeCharacters(String input) {
        // do nothing as it's a schema conversion
        return input;
    }

    @Override
    public String escapeQuotationMark(String input) {
        // do nothing as it's a schema conversion
        return input;
    }
    
}
