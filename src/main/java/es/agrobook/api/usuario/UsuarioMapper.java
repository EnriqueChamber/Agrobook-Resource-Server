package es.agrobook.api.usuario;

import java.util.Collection;
import java.util.List;

import org.mapstruct.*;
import org.springframework.security.core.GrantedAuthority;

import es.agrobook.dto.UsuarioDto;
import es.agrobook.dto.UsuarioFieldsDto;

@Mapper //(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    //#region ANY TO Usuario
    @Mappings({
        @Mapping(target = "expiredAccount", constant = "false"),
        @Mapping(target = "expiredCredentials", constant = "false"),
        @Mapping(target = "locked", constant = "false")
    })
    Usuario toUsuario(UsuarioDto usuarioDto);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "expiredAccount", constant = "false"),
        @Mapping(target = "expiredCredentials", constant = "false"),
        @Mapping(target = "locked", constant = "false")
    })
    Usuario toUsuario(UsuarioFieldsDto usuarioDto);

    Collection<Usuario> toUsuarios(Collection<UsuarioDto> usuarioDtos);
    //#endregion


    //#region ANY TO UsuarioDto
    @Mapping(target = "authorities", source = "authorities", qualifiedByName = "mapAuthorities")
    UsuarioDto toUsuarioDto(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    UsuarioDto toUsuarioDto(UsuarioFieldsDto usuarioDto);
    
    List<UsuarioDto> toUsuarioDtoCollection(Collection<Usuario> usuarioCollection);
    //#endregion


    //#region ANY TO UsuarioFieldsDto
    @Mapping(target = "authorities", source = "authorities", qualifiedByName = "mapAuthorities")
    UsuarioFieldsDto toUsuarioFieldsDto(Usuario usuario);

    UsuarioFieldsDto toUsuarioFieldsDto(UsuarioDto usuarioDto);
    //#endregion
    
    
    @Named("mapAuthorities") 
    default List<String> mapAuthorities(List<? extends GrantedAuthority> authorities){
        if(authorities == null)
            return null;
        return authorities.stream().map(authority -> authority.getAuthority()).toList();
    }
}