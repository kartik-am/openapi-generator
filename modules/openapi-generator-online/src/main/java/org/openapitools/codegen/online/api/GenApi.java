/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
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

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.codegen.online.api;

import io.swagger.annotations.*;
import org.openapitools.codegen.CliOption;
import org.openapitools.codegen.online.model.GeneratorInput;
import org.openapitools.codegen.online.model.ResponseCode;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(value = "gen", description = "the gen API")
public interface GenApi {
    GenApiDelegate getDelegate();

    @ApiOperation(value = "Gets languages supported by the client generator", nickname = "clientOptions", notes = "", response = String.class, responseContainer = "List", tags={ "clients", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = String.class, responseContainer = "List") })
    @RequestMapping(value = "/gen/clients",
            method = RequestMethod.GET)
    default ResponseEntity<List<String>> clientOptions() {
        return getDelegate().clientOptions();
    }


    @ApiOperation(value = "Downloads a pre-generated file", nickname = "downloadFile", notes = "A valid `fileId` is generated by the `/clients/{language}` or `/servers/{language}` POST operations.  The fileId code can be used just once, after which a new `fileId` will need to be requested.", response = MultipartFile.class, tags={ "clients","servers", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = MultipartFile.class) })
    @RequestMapping(value = "/gen/download/{fileId}",
            produces = { "application/octet-stream" },
            method = RequestMethod.GET)
    default ResponseEntity<Resource> downloadFile(@ApiParam(value = "",required=true) @PathVariable("fileId") String fileId) {
        return getDelegate().downloadFile(fileId);
    }


    @ApiOperation(value = "Generates a client library", nickname = "generateClient", notes = "Accepts a `GeneratorInput` options map for spec location and generation options", response = ResponseCode.class, tags={ "clients", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseCode.class) })
    @RequestMapping(value = "/gen/clients/{language}",
            method = RequestMethod.POST)
    default ResponseEntity<ResponseCode> generateClient(@ApiParam(value = "The target language for the client library",required=true) @PathVariable("language") String language,@ApiParam(value = "Configuration for building the client library" ,required=true )  @Valid @RequestBody GeneratorInput generatorInput) {
        return getDelegate().generateClient(language, generatorInput);
    }


    @ApiOperation(value = "Generates a server library", nickname = "generateServerForLanguage", notes = "Accepts a `GeneratorInput` options map for spec location and generation options.", response = ResponseCode.class, tags={ "servers", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseCode.class) })
    @RequestMapping(value = "/gen/servers/{framework}",
            method = RequestMethod.POST)
    default ResponseEntity<ResponseCode> generateServerForLanguage(@ApiParam(value = "framework",required=true) @PathVariable("framework") String framework,@ApiParam(value = "parameters" ,required=true )  @Valid @RequestBody GeneratorInput generatorInput) {
        return getDelegate().generateServerForLanguage(framework, generatorInput);
    }


    @ApiOperation(value = "Returns options for a client library", nickname = "getClientOptions", notes = "", tags={ "clients", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/gen/clients/{language}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Map<String, CliOption>> getClientOptions(@ApiParam(value = "The target language for the client library",required=true) @PathVariable("language") String language) {
        return getDelegate().getClientOptions(language);
    }


    @ApiOperation(value = "Returns options for a server framework", nickname = "getServerOptions", notes = "", tags={ "servers", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/gen/servers/{framework}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Map<String, CliOption>> getServerOptions(@ApiParam(value = "The target language for the server framework",required=true) @PathVariable("framework") String framework) {
        return getDelegate().getServerOptions(framework);
    }


    @ApiOperation(value = "Gets languages supported by the server generator", nickname = "serverOptions", notes = "", response = String.class, responseContainer = "List", tags={ "servers", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = String.class, responseContainer = "List") })
    @RequestMapping(value = "/gen/servers",
            method = RequestMethod.GET)
    default ResponseEntity<List<String>> serverOptions() {
        return getDelegate().serverOptions();
    }
    
    @ApiOperation(value = "Generates a schema", nickname = "generateSchema", notes = "Accepts a `GeneratorInput` options map for spec location and generation options", response = ResponseCode.class, tags={ "schema", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ResponseCode.class) })
    @RequestMapping(value = "/gen/schema/{language}",
            method = RequestMethod.POST)
    default ResponseEntity<ResponseCode> generateSchema(@ApiParam(value = "The target language for the client library",required=true) @PathVariable("language") String language,@ApiParam(value = "Configuration for building the client library" ,required=true )  @Valid @RequestBody GeneratorInput generatorInput) {
        return getDelegate().generateSchema(language, generatorInput);
    }

}
