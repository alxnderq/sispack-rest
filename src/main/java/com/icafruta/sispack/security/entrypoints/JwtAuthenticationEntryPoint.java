package com.icafruta.sispack.security.entrypoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icafruta.sispack.dto.response.ResponseBaseDTO;
import com.icafruta.sispack.utils.MessageError;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Autowired
    private Environment env;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeader(HttpHeaders.ORIGIN));
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                    request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS));
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                    request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        } else {
            this.updateHeaders(response);
            ObjectMapper mapper = new ObjectMapper();
            ResponseBaseDTO baseDTO = new ResponseBaseDTO(MessageError.OPERACION_ERRONEA,
                    MessageError.ERROR_CUENTA_SIN_PERMISOS,
                    env.getProperty(MessageError.getPropertyMessage(MessageError.ERROR_CUENTA_SIN_PERMISOS)),
                    StringUtils.EMPTY);
            mapper.writeValue(response.getWriter(), baseDTO);
            response.getWriter().flush();
        }
    }

    private void updateHeaders(HttpServletResponse response) {
        response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
