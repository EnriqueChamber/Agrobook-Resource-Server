package es.agrobook.api.usuario;

import es.agrobook.dto.UsuarioDto;
import es.agrobook.dto.UsuarioFieldsDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        List<String> list = usuarioDto.getAuthorities();
        if ( list != null ) {
            usuario.authorities( new ArrayList<String>( list ) );
        }
        usuario.enabled( usuarioDto.getEnabled() );
        usuario.id( usuarioDto.getId() );
        usuario.password( usuarioDto.getPassword() );
        usuario.username( usuarioDto.getUsername() );

        usuario.expiredAccount( false );
        usuario.expiredCredentials( false );
        usuario.locked( false );

        return usuario.build();
    }

    @Override
    public Usuario toUsuario(UsuarioFieldsDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        List<String> list = usuarioDto.getAuthorities();
        if ( list != null ) {
            usuario.authorities( new ArrayList<String>( list ) );
        }
        usuario.enabled( usuarioDto.getEnabled() );
        usuario.password( usuarioDto.getPassword() );
        usuario.username( usuarioDto.getUsername() );

        usuario.expiredAccount( false );
        usuario.expiredCredentials( false );
        usuario.locked( false );

        return usuario.build();
    }

    @Override
    public Collection<Usuario> toUsuarios(Collection<UsuarioDto> usuarioDtos) {
        if ( usuarioDtos == null ) {
            return null;
        }

        Collection<Usuario> collection = new ArrayList<Usuario>( usuarioDtos.size() );
        for ( UsuarioDto usuarioDto : usuarioDtos ) {
            collection.add( toUsuario( usuarioDto ) );
        }

        return collection;
    }

    @Override
    public UsuarioDto toUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setAuthorities( mapAuthorities( usuario.getAuthorities() ) );
        usuarioDto.setId( usuario.getId() );
        usuarioDto.setUsername( usuario.getUsername() );
        usuarioDto.setPassword( usuario.getPassword() );
        usuarioDto.setEnabled( usuario.getEnabled() );

        return usuarioDto;
    }

    @Override
    public UsuarioDto toUsuarioDto(UsuarioFieldsDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        UsuarioDto usuarioDto1 = new UsuarioDto();

        usuarioDto1.setUsername( usuarioDto.getUsername() );
        usuarioDto1.setPassword( usuarioDto.getPassword() );
        usuarioDto1.setEnabled( usuarioDto.getEnabled() );
        List<String> list = usuarioDto.getAuthorities();
        if ( list != null ) {
            usuarioDto1.setAuthorities( new ArrayList<String>( list ) );
        }

        return usuarioDto1;
    }

    @Override
    public List<UsuarioDto> toUsuarioDtoCollection(Collection<Usuario> usuarioCollection) {
        if ( usuarioCollection == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( usuarioCollection.size() );
        for ( Usuario usuario : usuarioCollection ) {
            list.add( toUsuarioDto( usuario ) );
        }

        return list;
    }

    @Override
    public UsuarioFieldsDto toUsuarioFieldsDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioFieldsDto usuarioFieldsDto = new UsuarioFieldsDto();

        usuarioFieldsDto.setAuthorities( mapAuthorities( usuario.getAuthorities() ) );
        usuarioFieldsDto.setUsername( usuario.getUsername() );
        usuarioFieldsDto.setPassword( usuario.getPassword() );
        usuarioFieldsDto.setEnabled( usuario.getEnabled() );

        return usuarioFieldsDto;
    }

    @Override
    public UsuarioFieldsDto toUsuarioFieldsDto(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        UsuarioFieldsDto usuarioFieldsDto = new UsuarioFieldsDto();

        usuarioFieldsDto.setUsername( usuarioDto.getUsername() );
        usuarioFieldsDto.setPassword( usuarioDto.getPassword() );
        usuarioFieldsDto.setEnabled( usuarioDto.getEnabled() );
        List<String> list = usuarioDto.getAuthorities();
        if ( list != null ) {
            usuarioFieldsDto.setAuthorities( new ArrayList<String>( list ) );
        }

        return usuarioFieldsDto;
    }
}
