package com.icafruta.sispack.controller;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.UserDTO;
import com.icafruta.sispack.dto.response.ResponseBaseDTO;
import com.icafruta.sispack.dto.response.ResponseListaPersonalDTO;
import com.icafruta.sispack.dto.response.ResponsePersonalDTO;
import com.icafruta.sispack.security.providers.RESTUserDetails;
import com.icafruta.sispack.service.SecurityService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alxnderq on 13/11/2016.
 */
@RestController
public class SecurityController extends BaseController{

    @Autowired
    private SecurityService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/security/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePersonalDTO> findByUser(@RequestBody UserDTO dto, HttpServletRequest request){
        final Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        ResponsePersonalDTO login = new ResponsePersonalDTO();
        login.setUsuario(((RESTUserDetails) auth.getPrincipal()).getUsuario());

        login.setToken(generateToken(login.getUsuario()));
        return responseData(login, request);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<ResponseListaPersonalDTO> findAll(HttpServletRequest request){
        ResponseListaPersonalDTO response = new ResponseListaPersonalDTO();
        response.setLista(service.findAll());
        return responseData(response, request);
    }
}
