package com.icafruta.sispack.controller;

import com.icafruta.sispack.dto.UserDTO;
import com.icafruta.sispack.dto.response.ResponseListaPersonalDTO;
import com.icafruta.sispack.dto.response.ResponseLoginDTO;
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

/**
 * Created by alxnderq on 13/11/2016.
 */
@RestController
public class SecurityController extends BaseController{

    @Autowired
    private SecurityService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseLoginDTO> findByUser(@RequestBody UserDTO dto, HttpServletRequest request){
        final Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        ResponseLoginDTO login = new ResponseLoginDTO();
        login.setData(((RESTUserDetails) auth.getPrincipal()).getLogin());
        ResponseEntity<ResponseLoginDTO> response = responseData(login, request);
        login.setToken(generateToken(login.getData().getPersonal()));
        return response;
    }
}
