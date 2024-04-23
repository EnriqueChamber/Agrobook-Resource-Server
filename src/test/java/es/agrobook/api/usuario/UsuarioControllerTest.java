package es.agrobook.api.usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;
import static es.agrobook.api.utils.ResponseBodyMatchers.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.agrobook.dto.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private ObjectMapper objectMapper;

    private List<Usuario> usuarios;

    private static Long testId = 1L;

    private final String path = "/api/usuarios";


    @BeforeEach
    void initUsuarios() {
        usuarios = Arrays.asList(
            Usuario.builder()
            .id(1L)
            .username("adminUser")
            .password("abc123")
            .enabled(true)
            .expiredAccount(false)
            .locked(false)
            .expiredCredentials(false)
            .authorities(Arrays.asList("ADMIN", "USER"))
            .build(),

            Usuario.builder()
            .id(2L)
            .username("defaultUser")
            .password("abc123")
            .enabled(true)
            .expiredAccount(false)
            .locked(false)
            .expiredCredentials(false)
            .authorities(Arrays.asList("USER"))
            .build(),

            Usuario.builder()
            .id(3L)
            .username("disabledUser")
            .password("abc123")
            .enabled(false)
            .expiredAccount(false)
            .locked(false)
            .expiredCredentials(false)
            .authorities(Arrays.asList("ADMIN", "USER"))
            .build(),

            Usuario.builder()
            .id(4L)
            .username("totallyModifiedUser")
            .password("def456")
            .enabled(false)
            .expiredAccount(true)
            .locked(true)
            .expiredCredentials(true)
            .authorities(Arrays.asList("TESTER"))
            .build()
        );
    }


    // listUsuarios Tests
    @Test
    void testListUsuarios_Success() throws Exception {
        // Given
        List<UsuarioDto> expectedUsuarioDtos = usuarioMapper.toUsuarioDtoCollection(usuarios);
        given(usuarioRepository.findAll()).willReturn(usuarios);

        URI currentPath = fromPath(path).build().toUri();

        // When
        mockMvc.perform(get(currentPath)
            .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isOk()) // Not Found in case of empty list?
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsObjectAsJson(expectedUsuarioDtos, new TypeReference<List<UsuarioDto>>(){}));
        
        verify(usuarioRepository, times(1)).findAll();
    }

    @Disabled
    @Test
    void testListUsuarios_NotModified() throws Exception {

    }

    // addUsuario Tests
    @Test
    void testAddUsuario_Success() throws Exception {
        // Given
        Usuario expectedUsuario = usuarios.get(0);
        UsuarioDto expectedUsuarioDto = usuarioMapper.toUsuarioDto(expectedUsuario);
        UsuarioFieldsDto expectedUsuarioFieldsDto = usuarioMapper.toUsuarioFieldsDto(expectedUsuario);

        given(usuarioRepository.saveAndFlush(any(Usuario.class)))
        .willReturn(expectedUsuario);
        
        URI currentPath = fromPath(path).build().toUri();

        // When
        mockMvc.perform(post(currentPath)
                .content(objectMapper.writeValueAsString(expectedUsuarioFieldsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsObjectAsJson(expectedUsuarioDto, UsuarioDto.class));
        
        ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(usuarioRepository, times(1)).saveAndFlush(usuarioCaptor.capture());
        
        Usuario capturedUsuario = usuarioCaptor.getValue();
        Usuario mappedUsuario = usuarioMapper.toUsuario(expectedUsuarioFieldsDto);
        assertEquals(mappedUsuario, capturedUsuario);

        // May also check if mapper worked fine?
    }

    @Test
    void testAddUsuario_BadRequest() throws Exception {
        // Given
        UsuarioFieldsDto paramsUsuarioFieldsDto = new UsuarioFieldsDto();

        URI currentPath = fromPath(path).build().toUri();

        // When
        mockMvc.perform(post(currentPath)
                .content(objectMapper.writeValueAsString(paramsUsuarioFieldsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsError(wrongArgumentsError(currentPath)));

        verify(usuarioRepository, times(0)).saveAndFlush(any(Usuario.class));
    }

    // getUsuario Tests
    @Test
    void testGetUsuario_Success() throws Exception {
        // Given
        Usuario expectedUsuario = usuarios.get(0);
        UsuarioDto expectedUsuarioDto = usuarioMapper.toUsuarioDto(expectedUsuario);

        given(usuarioRepository.findById(expectedUsuario.getId())).willReturn(Optional.of(expectedUsuario));

        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(expectedUsuario.getId()).toUri();
        
        // When
        mockMvc.perform(get(currentPath)
            .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsObjectAsJson(expectedUsuarioDto, expectedUsuarioDto.getClass()));

        verify(usuarioRepository, times(1)).findById(anyLong());
    }

    @Disabled
    @Test
    void testGetUsuario_NotModified() throws Exception {

    }

    @Test
    void testGetUsuario_NotFound() throws Exception {
        // Given
        Optional<Usuario> expectedUsuario = Optional.empty();

        given(usuarioRepository.findById(testId)).willReturn(expectedUsuario);
        
        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(testId).toUri();
        
        // When
        mockMvc.perform(get(currentPath)
            .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsError(notFoundError(currentPath)));

        verify(usuarioRepository, times(1)).findById(anyLong());
    }

    // updateUsuario Tests
    @Test
    void testUpdateUsuario_Success() throws Exception {
        // Given
        Usuario expectedUsuario = usuarios.get(3);
        expectedUsuario.setId(1L);
        UsuarioDto expectedUsuarioDto = usuarioMapper.toUsuarioDto(expectedUsuario);
        UsuarioFieldsDto paramsUsuarioFieldsDto = usuarioMapper.toUsuarioFieldsDto(expectedUsuario);

        given(usuarioRepository.existsById(expectedUsuario.getId()))
        .willReturn(true);
        given(usuarioRepository.saveAndFlush(any(Usuario.class)))
        .willReturn(expectedUsuario);
        
        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(expectedUsuario.getId()).toUri();

        // When
        mockMvc.perform(put(currentPath)
            .content(objectMapper.writeValueAsString(paramsUsuarioFieldsDto))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsObjectAsJson(expectedUsuarioDto, expectedUsuarioDto.getClass()));

            verify(usuarioRepository, times(1)).existsById(anyLong());
            verify(usuarioRepository, times(1)).saveAndFlush(any(Usuario.class));
    }

    @Test
    void testUpdateUsuario_NotFound() throws Exception {
        // Given
        Usuario expectedUsuario = usuarios.get(3);
        expectedUsuario.setId(5L);
        UsuarioFieldsDto paramsUsuarioFieldsDto = usuarioMapper.toUsuarioFieldsDto(expectedUsuario);

        given(usuarioRepository.existsById(expectedUsuario.getId()))
        .willReturn(false);
        
        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(expectedUsuario.getId()).toUri();

        // When
        mockMvc.perform(put(currentPath)
            .content(objectMapper.writeValueAsString(paramsUsuarioFieldsDto))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsError(notFoundError(currentPath)));

            verify(usuarioRepository, times(1)).existsById(anyLong());
            verify(usuarioRepository, times(0)).saveAndFlush(any(Usuario.class));
    }

    @Test
    void testUpdateUsuario_BadRequest() throws Exception {
        // Given
        UsuarioFieldsDto paramsUsuarioFieldsDto = new UsuarioFieldsDto();

        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(testId).toUri();

        // When
        mockMvc.perform(put(currentPath)
                .content(objectMapper.writeValueAsString(paramsUsuarioFieldsDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsError(wrongArgumentsError(currentPath)));

        verify(usuarioRepository, times(0)).saveAndFlush(any(Usuario.class));
    }

    // deleteUsuario Tests
    @Test
    void testDeleteUsuario_Success() throws Exception {
        // Given
        given(usuarioRepository.existsById(testId))
        .willReturn(true);

        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(testId).toUri();

        // Requires implement specific assertion function for RestMessageDto comparison
        // RestMessageDto expectedMessageDto = new RestMessageDto(new URI(""), null, "Usuario eliminado correctamente");

        // When
        mockMvc.perform(delete(currentPath)
                .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
            //.andExpect(responseBody().containsObjectAsJson(expectedMessageDto, expectedMessageDto.getClass()));

        verify(usuarioRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void testDeleteUsuario_NotFound() throws Exception {
        // Given
        given(usuarioRepository.existsById(testId))
        .willReturn(false);

        URI currentPath = fromPath(path).path("/{id}").buildAndExpand(testId).toUri();

        // When
        mockMvc.perform(delete(currentPath)
                .accept(MediaType.APPLICATION_JSON_VALUE))

        // Then
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(responseBody().containsError(notFoundError(currentPath)));

        verify(usuarioRepository, times(0)).deleteById(anyLong());
    }



    private static RestErrorDto notFoundError(URI currentPath){
        return new RestErrorDto(currentPath, null, "Usuario no encontrado", null);
    }

    private static RestErrorDto wrongArgumentsError(URI currentPath){
        RestErrorDto restErrorDto = new RestErrorDto(currentPath, null, "Validation failed for argument", null);
        restErrorDto.setValidationErrors(Arrays.asList(
            new ValidationMessageDto("username", "NotNull"),
            new ValidationMessageDto("password", "NotNull")
        ));
        return restErrorDto;
    }
}
