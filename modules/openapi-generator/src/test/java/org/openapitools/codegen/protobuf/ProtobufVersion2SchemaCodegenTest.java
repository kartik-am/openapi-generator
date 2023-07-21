/*
 * Copyright 2019 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.protobuf;

import org.apache.commons.io.FileUtils;
import org.mockito.MockedStatic;
import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.TestUtils;
import org.openapitools.codegen.config.CodegenConfigurator;
import org.openapitools.codegen.languages.ProtobufVersion2SchemaCodegen;
import org.openapitools.codegen.utils.ImplementationVersion;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mockStatic;
import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ProtobufVersion2SchemaCodegenTest {

    private static MockedStatic<ZonedDateTime> mockedDateStatic;

    private static MockedStatic<ImplementationVersion> mockedVersionStatic;

    @BeforeClass
    public void setup() {
        Clock clock = Clock.fixed(Instant.parse("2023-06-19T00:00:00Z"), ZoneId.of("UTC"));
        ZonedDateTime expectedDate = ZonedDateTime.now(clock);
        mockedDateStatic = mockStatic(ZonedDateTime.class);
        mockedDateStatic.when(ZonedDateTime::now).thenReturn(expectedDate);
        mockedVersionStatic = mockStatic(ImplementationVersion.class);
        mockedVersionStatic.when(ImplementationVersion::read).thenReturn("N/A");
    }

    @AfterClass
    public void finish() {
        mockedDateStatic.close();
        mockedVersionStatic.close();
    }

    @Test
    public void testBasicModel() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, "src/test/resources/3_0/petstore.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema-version-2/basicModel.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCustomDefaultValues() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, "src/test/resources/3_0/protobuf-schema-version-2/custom-default-values.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema-version-2/custom-default-values.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCustomOptions() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("customOptionsSpec", "src/test/resources/3_0/protobuf-schema/ama_custom_options.yaml");
        properties.put("enumStructNameAsPrefix", true);
        properties.put("fieldNamesInSnakeCase", true);
        properties.put("startEnumsWithUnspecified", true);
        properties.put("removeEnumValuePrefix", false);
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, "src/test/resources/3_0/protobuf-schema/custom-options.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        TestUtils.ensureContainsFile(files, output, "custom_options/ama_custom_options.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema-version-2/custom-options.proto"));
        path = Paths.get(output + "/custom_options/ama_custom_options.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema-version-2/ama_custom_options.proto"));
        FileUtils.deleteDirectory(output);
    }

    private List<File> generate(File output, Map<String, Object> properties, String inputFile) {        
        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("protobuf-schema-version-2")
                .setAdditionalProperties(properties)                
                .setInputSpec(inputFile)
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        
        return generator.opts(clientOptInput).generate();
    }
}