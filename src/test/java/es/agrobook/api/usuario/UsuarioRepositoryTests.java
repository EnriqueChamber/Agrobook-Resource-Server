package es.agrobook.api.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsuarioRepositoryTests {

    @Autowired
    UsuarioRepository usuarioRepositoryTest;

    @Test
    void findByUsernameExists() {
        // Given
        String username = "user1";
        Usuario usuario = Usuario.builder()
            .username(username)
            .password("abc123")
            .enabled(true)
            .locked(false)
            .expiredAccount(false)
            .expiredCredentials(false)
            .locked(false)
            .build();

        usuarioRepositoryTest.save(usuario);

        // When
        Usuario expectedUsuario = usuarioRepositoryTest.findByUsername(username);

        // Then
        assertEquals(usuario, expectedUsuario);
    }
    
    @Test
    void findByUsernameDoesNotExists() {
        // Given
        String username = "user1";

        // When
        Usuario expectedUsuario = usuarioRepositoryTest.findByUsername(username);

        // Then
        assertNull(expectedUsuario);
        
    }
}
