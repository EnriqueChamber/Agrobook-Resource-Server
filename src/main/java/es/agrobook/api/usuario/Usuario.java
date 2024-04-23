package es.agrobook.api.usuario;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario implements UserDetails{

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(nullable = false)
	private Boolean expiredAccount;

	@Column(nullable = false)
	private Boolean locked;

	@Column(nullable = false)
	private Boolean expiredCredentials;

    /* ETag Filter and Versioning is not implemented for now
	@Version
    private long version;*/

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;
	
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;

		String concatenatedAuthorities = authorities.stream().sorted().collect(Collectors.joining());
		String concatenatedUsuarioAuthorities = usuario.authorities.stream().sorted().collect(Collectors.joining());

        return Objects.equals(id, usuario.id) &&
               Objects.equals(username, usuario.username) &&
               Objects.equals(password, usuario.password) &&
               Objects.equals(enabled, usuario.enabled) &&
               Objects.equals(expiredAccount, usuario.expiredAccount) &&
               Objects.equals(locked, usuario.locked) &&
               Objects.equals(expiredCredentials, usuario.expiredCredentials) &&
			   Objects.equals(concatenatedAuthorities, concatenatedUsuarioAuthorities);
    }

    @Override
    public int hashCode() {
		String concatenatedAuthorities = authorities.stream().sorted().collect(Collectors.joining());
        return Objects.hash(id, username, password, enabled, expiredAccount, locked, expiredCredentials, concatenatedAuthorities);
    }
}
