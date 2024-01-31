/**
<<<<<<< HEAD
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.3-amadeus).
=======
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0-SNAPSHOT).
>>>>>>> 635f7952cec10eecf437886ccd03983b655cd6f2
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.time.OffsetDateTime;
import org.openapitools.model.User;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "user", description = "Operations about user")
public interface UserApi {

    /**
     * POST /user : Create user
     * This can only be done by the logged in user.
     *
     * @param user Created user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "createUser",
        summary = "Create user",
        description = "This can only be done by the logged in user.",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "default", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user",
        consumes = "application/json"
    )
    ResponseEntity<Void> createUser(
        @Parameter(name = "User", description = "Created user object", required = true) @Valid @RequestBody User user
    );


    /**
     * POST /user/createWithArray : Creates list of users with given input array
     * 
     *
     * @param user List of user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "createUsersWithArrayInput",
        summary = "Creates list of users with given input array",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "default", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/createWithArray",
        consumes = "application/json"
    )
    ResponseEntity<Void> createUsersWithArrayInput(
        @Parameter(name = "User", description = "List of user object", required = true) @Valid @RequestBody List<User> user
    );


    /**
     * POST /user/createWithList : Creates list of users with given input array
     * 
     *
     * @param user List of user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "createUsersWithListInput",
        summary = "Creates list of users with given input array",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "default", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/createWithList",
        consumes = "application/json"
    )
    ResponseEntity<Void> createUsersWithListInput(
        @Parameter(name = "User", description = "List of user object", required = true) @Valid @RequestBody List<User> user
    );


    /**
     * DELETE /user/{username} : Delete user
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted (required)
     * @return Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "deleteUser",
        summary = "Delete user",
        description = "This can only be done by the logged in user.",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/user/{username}"
    )
    ResponseEntity<Void> deleteUser(
        @Parameter(name = "username", description = "The name that needs to be deleted", required = true, in = ParameterIn.PATH) @PathVariable("username") String username
    );


    /**
     * GET /user/{username} : Get user by user name
     * 
     *
     * @param username The name that needs to be fetched. Use user1 for testing. (required)
     * @return successful operation (status code 200)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "getUserByName",
        summary = "Get user by user name",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid username supplied"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/{username}",
        produces = "application/json"
    )
    ResponseEntity<User> getUserByName(
        @Parameter(name = "username", description = "The name that needs to be fetched. Use user1 for testing.", required = true, in = ParameterIn.PATH) @PathVariable("username") String username
    );


    /**
     * GET /user/login : Logs user into the system
     * 
     *
     * @param username The user name for login (required)
     * @param password The password for login in clear text (required)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     */
    @Operation(
        operationId = "loginUser",
        summary = "Logs user into the system",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/xml", schema = @Schema(implementation = String.class)),
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid username/password supplied")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/login",
        produces = "application/json"
    )
    ResponseEntity<String> loginUser(
        @NotNull @Parameter(name = "username", description = "The user name for login", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "username", required = true) String username,
        @NotNull @Parameter(name = "password", description = "The password for login in clear text", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "password", required = true) String password
    );


    /**
     * GET /user/logout : Logs out current logged in user session
     * 
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "logoutUser",
        summary = "Logs out current logged in user session",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "default", description = "successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user/logout"
    )
    ResponseEntity<Void> logoutUser(
        
    );


    /**
     * PUT /user/{username} : Updated user
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted (required)
     * @param user Updated user object (required)
     * @return Invalid user supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(
        operationId = "updateUser",
        summary = "Updated user",
        description = "This can only be done by the logged in user.",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user/{username}",
        consumes = "application/json"
    )
    ResponseEntity<Void> updateUser(
        @Parameter(name = "username", description = "name that need to be deleted", required = true, in = ParameterIn.PATH) @PathVariable("username") String username,
        @Parameter(name = "User", description = "Updated user object", required = true) @Valid @RequestBody User user
    );

}
