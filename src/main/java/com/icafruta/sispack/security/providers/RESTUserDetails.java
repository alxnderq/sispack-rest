package com.icafruta.sispack.security.providers;

import com.icafruta.sispack.dto.LoginDTO;
import com.icafruta.sispack.dto.PersonalDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class RESTUserDetails implements UserDetails {

    private LoginDTO login;
    private final Collection<? extends GrantedAuthority> authorities;

    public RESTUserDetails(LoginDTO login, Collection<? extends GrantedAuthority> authorities) {
        this.login = login;
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
        return login.getPersonal().getUsuario();
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
        return login.getPersonal().isEstado();
    }

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }
}
