package es.agrobook.api.usuario;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import es.agrobook.api.UsuariosApi;
import es.agrobook.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;



@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api")
@AllArgsConstructor
public class UsuarioController implements UsuariosApi{

    private final UsuarioRepository usuarioRepository;
    
    private final UsuarioMapper usuarioMapper;
    
    private final HttpServletRequest request;
    
    @Override
    public ResponseEntity<List<UsuarioDto>> listUsuarios() {
        return new ResponseEntity<>(usuarioMapper.toUsuarioDtoCollection(usuarioRepository.findAll()), HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<UsuarioDto> addUsuario(@Valid UsuarioFieldsDto usuarioFieldsDto) {
        Usuario createdUsuario = usuarioRepository.saveAndFlush(usuarioMapper.toUsuario(usuarioFieldsDto));
        URI location = UriComponentsBuilder
            .fromPath(request.getServletPath())
            .path("/{id}")
            .buildAndExpand(createdUsuario.getId())
            .toUri();
        return ResponseEntity.created(location).body(usuarioMapper.toUsuarioDto(createdUsuario));
    }

    @Override
    public ResponseEntity<UsuarioDto> getUsuario(@Min(1) Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isPresent())
            return ResponseEntity.ok(usuarioMapper.toUsuarioDto(usuario.get()));
        else
            throw new NoSuchElementException("Usuario no encontrado");
    }

    @Override
    public ResponseEntity<UsuarioDto> updateUsuario(@Min(1) Long idUsuario, @Valid UsuarioFieldsDto usuarioFieldsDto) {
        if(usuarioRepository.existsById(idUsuario)){
            Usuario usuario = usuarioMapper.toUsuario(usuarioFieldsDto);
            usuario.setId(idUsuario);
            return ResponseEntity.ok(usuarioMapper.toUsuarioDto(usuarioRepository.saveAndFlush(usuario)));
        }
        else{
            throw new NoSuchElementException("Usuario no encontrado");
            //throw new NotFoundException();
        }
    }

    @Override
    public ResponseEntity<RestMessageDto> deleteUsuario(@Min(1) Long idUsuario) {
        if(usuarioRepository.existsById(idUsuario)){
            usuarioRepository.deleteById(idUsuario);
            URI location = UriComponentsBuilder
                .fromPath(request.getServletPath())
                .build()
                .toUri();
            return ResponseEntity.ok(new RestMessageDto(location, OffsetDateTime.now(), "Usuario eliminado correctamente"));
        }
        else{
            throw new NoSuchElementException("Usuario no encontrado");
            //throw new NotFoundException();
        }
    }

}
