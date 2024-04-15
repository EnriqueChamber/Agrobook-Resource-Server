package es.agrobook.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-15T11:39:42.843018400+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class RestErrorDto {

  private Integer status;

  public RestErrorDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RestErrorDto(Integer status) {
    this.status = status;
  }

  public RestErrorDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP status code.
   * @return status
  */
  
  @Schema(name = "status", accessMode = Schema.AccessMode.READ_ONLY, example = "400", description = "The HTTP status code.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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
    return Objects.equals(this.status, restError.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestErrorDto {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

