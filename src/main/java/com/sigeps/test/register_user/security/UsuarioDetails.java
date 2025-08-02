package com.sigeps.test.register_user.security;

import com.sigeps.test.register_user.model.UsuarioModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioDetails implements UserDetails {

    private final UsuarioModel  usuarioModel;

    public UsuarioDetails(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(
                        usuarioModel
                                .getPerfil()
                                .name()
                )
        );
    }

    @Override
    public String getPassword() {
        return usuarioModel.getSenha();
    }

    @Override
    public String getUsername() {
        return usuarioModel.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuarioModel.getAtivo();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuarioModel.getAtivo();
    }
}
