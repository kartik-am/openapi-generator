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
import org.openapitools.codegen.languages.ProtobufSchemaCodegen;
import org.openapitools.codegen.meta.FeatureSet;
import org.openapitools.codegen.meta.features.WireFormatFeature;
import org.openapitools.codegen.utils.ImplementationVersion;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ProtobufSchemaCodegenTest {

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
    public void testCodeGenWithOneOf() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/oneOf.yaml");
        TestUtils.ensureContainsFile(files, output, "models/shape_all_of_shape_specialisation.proto");
        Path path = Paths.get(output + "/models/shape_all_of_shape_specialisation.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/shape_all_of_shape_specialisation.proto"));

        output.delete();
    }

    @Test
    public void testCodeGenWithOneOfSimple() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/oneOfSimple.yaml");
        TestUtils.ensureContainsFile(files, output, "models/shape.proto");
        Path path = Paths.get(output + "/models/shape.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/shape.proto"));

        output.delete();
    }

    @Test
    public void testCodeGen() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        File output = Files.createTempDirectory("test").toFile();
        assertThatThrownBy(() ->
                generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/allOf.yaml"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("At least components 'offerPayload_allOf_offerData_offerSet, travelOfferPayload_allOf_offerData_offerSet' are duplicated with differences. Maybe not listed components are duplicated too.");
    }

    @Test
    public void testFeatureSet() {
        final ProtobufSchemaCodegen codegen = new ProtobufSchemaCodegen();
        FeatureSet featureSet = codegen.getGeneratorMetadata().getFeatureSet();
        Assert.assertTrue(featureSet.getWireFormatFeatures().contains(WireFormatFeature.PROTOBUF));
        Assert.assertEquals(featureSet.getWireFormatFeatures().size(), 1);
    }

    @Test
    public void testCodeGenWithConflictingPropertiesName() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        properties.put("checkPropertiesDuplication", true);

        File output = Files.createTempDirectory("test").toFile();
        assertThatThrownBy(() ->
                generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/conflictPropertiesName.yaml"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Property 'var12' is duplicated with same protobuf index value");
    }

    @Test
    public void testCodeGenWithConflictingPropertiesNameWithInheritance() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        properties.put("checkPropertiesDuplication", true);

        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/conflictPropertiesNameWithInheritance.yaml");

        // TODO : Verify with Fabrice that is indeed the goal of this test
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/conflictPropertiesNameWithInheritancePet.proto"));
        TestUtils.ensureContainsFile(files, output, "models/cat.proto");
        path = Paths.get(output + "/models/cat.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/conflictPropertiesNameWithInheritanceCat.proto"));
        TestUtils.ensureContainsFile(files, output, "models/dog.proto");
        path = Paths.get(output + "/models/dog.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/conflictPropertiesNameWithInheritanceDog.proto"));

        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCodeGenWithConflictingPropertiesNumber() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        File output = Files.createTempDirectory("test").toFile();
        assertThatThrownBy(() ->
                generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/conflictPropertiesNumber.yaml"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("At least components 'offerPayload_allOf_offerData_offerSet, travelOfferPayload_allOf_offerData_offerSet' are duplicated with differences. Maybe not listed components are duplicated too.");
    }

    @Test
    public void testCodeGenWithConflictingPropertiesType() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");

        File output = Files.createTempDirectory("test").toFile();
        assertThatThrownBy(() ->
                generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/conflictPropertiesType.yaml"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("At least components 'offerPayload_allOf_offerData_offerSet, travelOfferPayload_allOf_offerData_offerSet' are duplicated with differences. Maybe not listed components are duplicated too.");
    }

    @Test
    public void testCodeGenWithAllOf() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        // set line break to \n across all platforms
        System.setProperty("line.separator", "\n");
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/allOf_composition_discriminator.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/pet.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionFieldNumber() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-field-number.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-field-number.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testAutomaticOrderedIndexGeneration() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("numberedFieldNumberList", "True");
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/automatic-ordered-index-generation.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/automatic-ordered-index-generation.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionNegativeIndex() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-negative-index.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Only strictly positive field numbers are allowed");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionNonIntegerIndex() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-non-integer-index.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "java.lang.String cannot be cast to java.lang.Integer");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionDuplicateIndexes() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-duplicate-indexes.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "A same field number is used multiple times");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionAutoGeneratedDuplicateIndexes() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-auto-generated-duplicate-indexes.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "A same field number is used multiple times");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    void testCodeGenWithEnum() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("startEnumsWithUnspecified", true);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/enum.yaml");
        TestUtils.ensureContainsFile(files, output, "models/status.proto");
        Path path = Paths.get(output + "/models/status.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/enum.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testNameSnakeCase() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("fieldNamesInSnakeCase", true);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/name-snakecase.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/name-snakecase.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionName() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-name.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-name.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionFieldName() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-field-name.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-field-name.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionDuplicateNames() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-duplicate-names.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "A same field name is used multiple times");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumIndexes() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-indexes.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-enum-indexes.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumMissingIndex() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-missing-index.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-enum-missing-index.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumDuplicateIndexes() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-duplicate-indexes.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Enum indexes must be unique");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumNegativeIndex() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-negative-index.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Negative enum field numbers are not allowed");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumNonIntegerIndex() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-non-integer-index.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "java.lang.String cannot be cast to java.lang.Integer");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumFirstValueZero() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-first-value-zero.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Enum definitions must start with enum value zero");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumZeroReserved() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        properties.put("startEnumsWithUnknown", true);
        File output = Files.createTempDirectory("test").toFile();
            try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-zero-reserved.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Field number zero reserved for first enum value");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumDescriptions() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-descriptions.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-enum-descriptions.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionEnumDuplicateNames() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-enum-duplicate-names.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Duplicate enum name");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionAmaEnum() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-ama-enum.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-ama-enum.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionAmaEnumNonMatchingItem() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-ama-enum-non-matching-item.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/extension-ama-enum-non-matching-item.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionAmaEnumDuplicateValues() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/extension-ama-enum-duplicate-values.yaml");
            fail("No exception thrown!");
        }
        catch (RuntimeException e) {
            assertEquals(e.getCause().getMessage(), "Duplicate value in x-ama-enum.values");
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testPropertyAnyType1() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();

        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/property-any-type-1.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/property-any-type.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testPropertyAnyType2() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();

        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/property-any-type-2.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/property-any-type.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testOperationAnyType() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();

        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/operation-any-type.yaml");
        TestUtils.ensureContainsFile(files, output, "services/default_service.proto");
        Path path = Paths.get(output + "/services/default_service.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/operation-any-type.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testNoDuplicateEnumUnknownValueAllOf() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("startEnumsWithUnknown", true);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();

        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/no-duplicate-enum-unknown-value-allOf.yaml");
        TestUtils.ensureContainsFile(files, output, "models/cat.proto");
        Path path = Paths.get(output + "/models/cat.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/no-duplicate-enum-unknown-value-allOf.proto"));

    }

    @Test
    public void testCustomOptions() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("customOptionsSpec", "src/test/resources/3_0/protobuf-schema/ama_custom_options.yaml");
        properties.put("enumStructNameAsPrefix", true);
        properties.put("fieldNamesInSnakeCase", true);
        properties.put("startEnumsWithUnspecified", true);
        properties.put("removeEnumValuePrefix", false);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/custom-options.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        TestUtils.ensureContainsFile(files, output, "custom_options/ama_custom_options.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/custom-options.proto"));
        path = Paths.get(output + "/custom_options/ama_custom_options.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/ama_custom_options.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCustomOptionArray() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("customOptionsSpec", "src/test/resources/3_0/protobuf-schema/ama_custom_options.yaml");
        properties.put("enumStructNameAsPrefix", true);
        properties.put("fieldNamesInSnakeCase", true);
        properties.put("startEnumsWithUnspecified", true);
        properties.put("removeEnumValuePrefix", false);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/custom-option-array.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/custom-option-array.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCustomOptionNoCategory() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("customOptionsSpec", "src/test/resources/3_0/protobuf-schema/ama_custom_options.yaml");
        properties.put("enumStructNameAsPrefix", true);
        properties.put("fieldNamesInSnakeCase", true);
        properties.put("startEnumsWithUnspecified", true);
        properties.put("removeEnumValuePrefix", false);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/custom-option-no-category.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/custom-option-no-category.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testCustomOptionsNotValidValue() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("customOptionsSpec", "src/test/resources/3_0/protobuf-schema/ama_custom_options.yaml");
        properties.put("enumStructNameAsPrefix", true);
        properties.put("fieldNamesInSnakeCase", true);
        properties.put("startEnumsWithUnspecified", true);
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        try {
            List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/custom-options-not-valid-value.yaml");
            fail("No exception thrown!");
        } catch (RuntimeException e) {
            assertTrue(e.getCause().getMessage().startsWith("value \"PERSONAL_DATA_FIELD_WRONG\" is not part of allowed enum values"));
        }
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testExtensionModelPackage() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/package_structure/my_package/foo/extension-package-name.yaml");
        // generation in different folders according to x-package-name
        TestUtils.ensureContainsFile(files, output, "my_package/foo/pet.proto");
        TestUtils.ensureContainsFile(files, output, "my_package/bar/photo.proto");
        TestUtils.ensureContainsFile(files, output, "models/tag.proto");
        Path path = Paths.get(output + "/my_package/foo/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/package_structure/my_package/foo/pet.proto"));
        path = Paths.get(output + "/my_package/bar/photo.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/package_structure/my_package/bar/photo.proto"));
        path = Paths.get(output + "/models/tag.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/package_structure/models/tag.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testTimeTypes() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/time-types.yaml");
        TestUtils.ensureContainsFile(files, output, "models/pet.proto");
        TestUtils.ensureContainsFile(files, output, "google/type/date.proto");
        TestUtils.ensureContainsFile(files, output, "google/type/timeofday.proto");
        Path path = Paths.get(output + "/models/pet.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/time-types.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testGoogleWrapper() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        properties.put("useWrapperTypes", true);
        properties.put("fieldNamesInSnakeCase", false);
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/google-wrapper-types.yaml");
        TestUtils.ensureContainsFile(files, output, "models/var1.proto");
        Path path = Paths.get(output + "/models/var1.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/google-wrapper-types.proto"));
        FileUtils.deleteDirectory(output);
    }

    @Test
    public void testReferenceFieldFix() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        properties.put("updateRefFieldPropertyParsing", "true");
        File output = Files.createTempDirectory("test").toFile();
        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/test-ref.yaml");
        TestUtils.ensureContainsFile(files, output, "models/var1.proto");
        Path path = Paths.get(output + "/models/var1.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/test-ref.proto"));
        FileUtils.deleteDirectory(output);
    }

    // This test uses the same input and output as testOperationAnyType because the $ref shouldn't be replaced by the fix
    @Test
    public void testReferenceFieldFixNoReplace() throws IOException {
        Map<String, Object> properties = new HashMap<>();
        Map<String, String> globalProperties = new HashMap<>();
        File output = Files.createTempDirectory("test").toFile();
        properties.put("updateRefFieldPropertyParsing", "true");

        List<File> files = generate(output, properties, globalProperties, "src/test/resources/3_0/protobuf-schema/operation-any-type.yaml");
        TestUtils.ensureContainsFile(files, output, "services/default_service.proto");
        Path path = Paths.get(output + "/services/default_service.proto");
        TestUtils.assertFileEquals(path, Paths.get("src/test/resources/3_0/protobuf-schema/operation-any-type.proto"));
        FileUtils.deleteDirectory(output);
    }

    private List<File> generate(File output, Map<String, Object> properties, Map<String, String> globalProperties, String inputFile) {
        final CodegenConfigurator configurator = new CodegenConfigurator()
                .setGeneratorName("protobuf-schema")
                .setAdditionalProperties(properties)
                .setGlobalProperties(globalProperties)
                .setInputSpec(inputFile)
                .setOutputDir(output.getAbsolutePath().replace("\\", "/"));

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        
        return generator.opts(clientOptInput).generate();
    }
}
