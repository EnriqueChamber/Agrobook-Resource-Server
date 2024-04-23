/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package es.agrobook.api;

import es.agrobook.dto.RestErrorDto;
import es.agrobook.dto.RestMessageDto;
import es.agrobook.dto.UsuarioDto;
import es.agrobook.dto.UsuarioFieldsDto;
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

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-23T22:54:51.413904600+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "usuario", description = "Endpoints relacionados con los usuarios.")
public interface UsuariosApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /usuarios : Crear usuario
     * Crea un nuevo usuario y devuelve los detalles del usuario creado
     *
     * @param usuarioFieldsDto El usuario a crear (required)
     * @return Usuario creado correctamente. (status code 200)
     *         or Bad request. (status code 400)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "addUsuario",
        summary = "Crear usuario",
        description = "Crea un nuevo usuario y devuelve los detalles del usuario creado",
        tags = { "usuario" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuario creado correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/usuarios",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<UsuarioDto> addUsuario(
        @Parameter(name = "UsuarioFieldsDto", description = "El usuario a crear", required = true) @Valid @RequestBody UsuarioFieldsDto usuarioFieldsDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /usuarios/{idUsuario} : Eliminar usuario
     * Elimina un usuario del registro dado un ID.
     *
     * @param idUsuario ID del usuario. (required)
     * @return Usuario eliminado correctamente. (status code 200)
     *         or Bad request. (status code 400)
     *         or Not found. (status code 404)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "deleteUsuario",
        summary = "Eliminar usuario",
        description = "Elimina un usuario del registro dado un ID.",
        tags = { "usuario" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestMessageDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not found.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/usuarios/{idUsuario}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<RestMessageDto> deleteUsuario(
        @Min(1L) @Parameter(name = "idUsuario", description = "ID del usuario.", required = true, in = ParameterIn.PATH) @PathVariable("idUsuario") Long idUsuario
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /usuarios/{idUsuario} : Obtener usuario
     * Obtiene los detalles de un usuario según su ID
     *
     * @param idUsuario ID del usuario. (required)
     * @return Listado de usuarios obtenido correctamente (status code 200)
     *         or Not modified. (status code 304)
     *         or Bad request. (status code 400)
     *         or Not Found (status code 404)
     *         or Error de Servidor (status code 500)
     */
    @Operation(
        operationId = "getUsuario",
        summary = "Obtener usuario",
        description = "Obtiene los detalles de un usuario según su ID",
        tags = { "usuario" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Listado de usuarios obtenido correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDto.class))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error de Servidor", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/usuarios/{idUsuario}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<UsuarioDto> getUsuario(
        @Min(1L) @Parameter(name = "idUsuario", description = "ID del usuario.", required = true, in = ParameterIn.PATH) @PathVariable("idUsuario") Long idUsuario
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /usuarios : Listar usuarios
     * Devuelve una lista de todos los usuarios registrados
     *
     * @return Listado de usuarios obtenido correctamente (status code 200)
     *         or Not modified. (status code 304)
     *         or Server error. (status code 500)
     */
    @Operation(
        operationId = "listUsuarios",
        summary = "Listar usuarios",
        description = "Devuelve una lista de todos los usuarios registrados",
        tags = { "usuario" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Listado de usuarios obtenido correctamente", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class)))
            }),
            @ApiResponse(responseCode = "304", description = "Not modified."),
            @ApiResponse(responseCode = "500", description = "Server error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/usuarios",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<UsuarioDto>> listUsuarios(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1 }, { \"id\" : 1 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /usuarios/{idUsuario} : Actualizar usuario
     * Actualiza los detalles de un usuario dado su ID.
     *
     * @param idUsuario ID del usuario. (required)
     * @param usuarioFieldsDto Usuario a actualizar (required)
     * @return Usuario actualizado correctamente. (status code 200)
     *         or Bad request. (status code 400)
     *         or Not Found (status code 404)
     *         or Error de Servidor (status code 500)
     */
    @Operation(
        operationId = "updateUsuario",
        summary = "Actualizar usuario",
        description = "Actualiza los detalles de un usuario dado su ID.",
        tags = { "usuario" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Error de Servidor", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RestErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/usuarios/{idUsuario}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<UsuarioDto> updateUsuario(
        @Min(1L) @Parameter(name = "idUsuario", description = "ID del usuario.", required = true, in = ParameterIn.PATH) @PathVariable("idUsuario") Long idUsuario,
        @Parameter(name = "UsuarioFieldsDto", description = "Usuario a actualizar", required = true) @Valid @RequestBody UsuarioFieldsDto usuarioFieldsDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"path\" : \"/api/usuarios\", \"trace\" : \"com.atlassian.oai.validator.springmvc.InvalidRequestException: ...\", \"validationErrors\" : [ { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" }, { \"field\" : \"name\", \"message\" : \"Instance type (null) does not match any allowed primitive type (allowed: ['string'])\" } ], \"message\" : \"Request failed schema validation\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
