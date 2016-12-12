package com.icafruta.sispack.service.impl;

import com.icafruta.sispack.dto.LoginDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.security.providers.RESTUserDetailsFactory;
import com.icafruta.sispack.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Service
public class RESTUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SecurityService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personal p = service.findByUser(username);
        if (p != null){
            LoginDTO dto = new LoginDTO(p.toPersonalDTO(), service.findProfile(p.getPerfil().getId()));
            return RESTUserDetailsFactory.create(dto);
        } else {
            throw new UsernameNotFoundException(String.format("No se encontro el usuario '%s'.", username));
        }
    }
}
