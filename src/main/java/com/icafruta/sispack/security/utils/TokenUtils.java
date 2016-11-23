package com.icafruta.sispack.security.utils;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.exceptions.HandleExceptions;
import com.icafruta.sispack.security.filters.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Component
public class TokenUtils extends HandleExceptions {

    @Value("${token.header}")
    String tokenHeader;

    @Autowired
    JwtTokenUtil jwt;

    public String getToken(HttpServletRequest request) {
        return request.getHeader(tokenHeader);
    }

    public String updateToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        return jwt.updateTokenController(authToken);
    }

    public String generateToken(PersonalDTO dto) {
        return jwt.getToken(dto);
    }

    public String getUserToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        return jwt.getUserToken(authToken);
    }

    public PersonalDTO getDataToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        return jwt.getPersonalDTO(authToken);
    }
}
