package es.agrobook.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import java.time.OffsetDateTime;
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

@Schema(name = "RestMessage", description = "The schema for all error responses.")
@JsonTypeName("RestMessage")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-23T22:54:51.413904600+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class RestMessageDto {

  private URI path;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  private String message;

  public RestMessageDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RestMessageDto(URI path, OffsetDateTime timestamp, String message) {
    this.path = path;
    this.timestamp = timestamp;
    this.message = message;
  }

  public RestMessageDto path(URI path) {
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

  public RestMessageDto timestamp(OffsetDateTime timestamp) {
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

  public RestMessageDto message(String message) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestMessageDto restMessage = (RestMessageDto) o;
    return Objects.equals(this.path, restMessage.path) &&
        Objects.equals(this.timestamp, restMessage.timestamp) &&
        Objects.equals(this.message, restMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, timestamp, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMessageDto {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

