package es.agrobook.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import es.agrobook.dto.ValidationMessageDto;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The schema for all error responses.
 */

@Schema(name = "RestError", description = "The schema for all error responses.")
@JsonTypeName("RestError")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-23T22:54:51.413904600+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class RestErrorDto {

  private URI path;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private String message;

  @Valid
  private List<ValidationMessageDto> validationErrors;

  private String trace;

  public RestErrorDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RestErrorDto(URI path, OffsetDateTime timestamp, String message, String trace) {
    this.path = path;
    this.timestamp = timestamp;
    this.message = message;
    this.trace = trace;
  }

  public RestErrorDto path(URI path) {
    this.path = path;
    return this;
  }

  /**
   * The path of the URL for this request.
   * @return path
  */
  @Valid 
  @Schema(name = "path", accessMode = Schema.AccessMode.READ_ONLY, example = "/api/usuarios", description = "The path of the URL for this request.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("path")
  public URI getPath() {
    return path;
  }

  public void setPath(URI path) {
    this.path = path;
  }

  public RestErrorDto timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The time the error occured.
   * @return timestamp
  */
  @Valid 
  @Schema(name = "timestamp", accessMode = Schema.AccessMode.READ_ONLY, description = "The time the error occured.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public RestErrorDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The long error message.
   * @return message
  */
  
  @Schema(name = "message", accessMode = Schema.AccessMode.READ_ONLY, example = "Request failed schema validation", description = "The long error message.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public RestErrorDto validationErrors(List<ValidationMessageDto> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public RestErrorDto addValidationErrorsItem(ValidationMessageDto validationErrorsItem) {
    if (this.validationErrors == null) {
      this.validationErrors = new ArrayList<>();
    }
    this.validationErrors.add(validationErrorsItem);
    return this;
  }

  /**
   * Validation errors against the OpenAPI schema.
   * @return validationErrors
  */
  @Valid 
  @Schema(name = "validationErrors", description = "Validation errors against the OpenAPI schema.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validationErrors")
  public List<ValidationMessageDto> getValidationErrors() {
    return validationErrors;
  }

  public void setValidationErrors(List<ValidationMessageDto> validationErrors) {
    this.validationErrors = validationErrors;
  }

  public RestErrorDto trace(String trace) {
    this.trace = trace;
    return this;
  }

  /**
   * The stacktrace for this error.
   * @return trace
  */
  
  @Schema(name = "trace", accessMode = Schema.AccessMode.READ_ONLY, example = "com.atlassian.oai.validator.springmvc.InvalidRequestException: ...", description = "The stacktrace for this error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("trace")
  public String getTrace() {
    return trace;
  }

  public void setTrace(String trace) {
    this.trace = trace;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestErrorDto restError = (RestErrorDto) o;
    return Objects.equals(this.path, restError.path) &&
        Objects.equals(this.timestamp, restError.timestamp) &&
        Objects.equals(this.message, restError.message) &&
        Objects.equals(this.validationErrors, restError.validationErrors) &&
        Objects.equals(this.trace, restError.trace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, timestamp, message, validationErrors, trace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestErrorDto {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    validationErrors: ").append(toIndentedString(validationErrors)).append("\n");
    sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

