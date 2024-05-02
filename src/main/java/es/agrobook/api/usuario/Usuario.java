package es.agrobook.api.usuario;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ApiModel(description = "User model")
public class Usuario implements UserDetails{

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique ID of the user")
	private Long id;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The unique username of the user")
	private String username;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The password of the user")
	private String password;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The enabled check of the user")
	private Boolean enabled;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The expired account check of the user")
	private Boolean expiredAccount;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The locked check of the user")
	private Boolean locked;

	@Column(nullable = false)
    @ApiModelProperty(notes = "The expired credentials check of the user")
	private Boolean expiredCredentials;

    /* ETag Filter and Versioning is not implemented for now
	@Version
    private long version;*/

    @ElementCollection(fetch = FetchType.EAGER)
    @ApiModelProperty(notes = "The authorities list of the user")
    private List<String> authorities;


	/*@ManyToOne
	private Usuario supervisor;

	@OneToMany(mappedBy = "supervisor")
	private List<Usuario> supervisados;*/


	
	@Override
	public List<? extends GrantedAuthority> getAuthorities() {
		if(authorities == null)
			return null;
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return !expiredAccount.booleanValue();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked.booleanValue();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !expiredCredentials.booleanValue();
	}

	@Override
	public boolean isEnabled() {
		return enabled.booleanValue();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
}
