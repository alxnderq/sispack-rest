package com.icafruta.sispack.controller;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.response.ResponseBaseDTO;
import com.icafruta.sispack.exceptions.HandleExceptions;
import com.icafruta.sispack.security.utils.TokenUtils;
import com.icafruta.sispack.utils.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alxnderq on 13/11/2016.
 */
@RestController
@RequestMapping(value = "${rest.route.auth}", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController extends HandleExceptions{

    @Autowired
    LoggerService logger;

    @Autowired
    TokenUtils token;

    public <T> ResponseEntity<T> responseData(T response, HttpServletRequest request) {
        if (response instanceof ResponseBaseDTO) {
            ((ResponseBaseDTO) response).setOperacion(1);
            ((ResponseBaseDTO) response).setCodigo(HttpStatus.OK.value());
            ((ResponseBaseDTO) response).setToken(token.updateToken(request));
        }
        return new ResponseEntity<T>(response, HttpStatus.OK);
    }

    public String generateToken(PersonalDTO dto) {
        return token.generateToken(dto);
    }

    public PersonalDTO dataToken(HttpServletRequest request) {
        return token.getDataToken(request);
    }
}
