package es.agrobook.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Usuario de la aplicación
 */

@Schema(name = "Usuario", description = "Usuario de la aplicación")
@JsonTypeName("Usuario")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-23T22:54:51.413904600+02:00[Europe/Madrid]", comments = "Generator version: 7.4.0")
public class UsuarioDto {

  private Long id;

  private String username;

  private String password;

  private Boolean enabled;

  @Valid
  private List<String> authorities;

  public UsuarioDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UsuarioDto(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public UsuarioDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID del Usuario
   * minimum: 1
   * @return id
  */
  @Min(1L) 
  @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "1", description = "ID del Usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UsuarioDto username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Nombre de usuario de acceso a la aplicación
   * @return username
  */
  @NotNull @Size(min = 1, max = 80) 
  @Schema(name = "username", example = "john.doe", description = "Nombre de usuario de acceso a la aplicación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UsuarioDto password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Constraseña empleada por el usuario para el acceso a la aplicación
   * @return password
  */
  @NotNull @Size(min = 1, max = 80) 
  @Schema(name = "password", example = "1234abc", description = "Constraseña empleada por el usuario para el acceso a la aplicación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UsuarioDto enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Indica si el usuario está habilitado
   * @return enabled
  */
  
  @Schema(name = "enabled", example = "true", description = "Indica si el usuario está habilitado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enabled")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public UsuarioDto authorities(List<String> authorities) {
    this.authorities = authorities;
    return this;
  }

  public UsuarioDto addAuthoritiesItem(String authoritiesItem) {
    if (this.authorities == null) {
      this.authorities = new ArrayList<>();
    }
    this.authorities.add(authoritiesItem);
    return this;
  }

  /**
   * The authorities of an user
   * @return authorities
  */
  
  @Schema(name = "authorities", description = "The authorities of an user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorities")
  public List<String> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<String> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarioDto usuario = (UsuarioDto) o;
    return Objects.equals(this.id, usuario.id) &&
        Objects.equals(this.username, usuario.username) &&
        Objects.equals(this.password, usuario.password) &&
        Objects.equals(this.enabled, usuario.enabled) &&
        Objects.equals(this.authorities, usuario.authorities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, enabled, authorities);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    authorities: ").append(toIndentedString(authorities)).append("\n");
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

