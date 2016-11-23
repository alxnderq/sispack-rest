package com.icafruta.sispack.security.providers;

import com.icafruta.sispack.dto.PersonalDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class RESTUserDetails implements UserDetails {

    private PersonalDTO usuario;
    private final Collection<? extends GrantedAuthority> authorities;

    public RESTUserDetails(PersonalDTO usuario, Collection<? extends GrantedAuthority> authorities) {
        this.usuario = usuario;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return usuario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuario.isEstado();
    }

    public PersonalDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(PersonalDTO usuario) {
        this.usuario = usuario;
    }
}
