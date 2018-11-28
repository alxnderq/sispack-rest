package com.icafruta.sispack.exceptions;

import com.icafruta.sispack.dto.response.ResponseBaseDTO;
import com.icafruta.sispack.utils.LoggerService;
import com.icafruta.sispack.utils.MessageError;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class HandleExceptions {

    @Autowired
    LoggerService logger;

    @Autowired
    Environment env;

    private ResponseEntity<ResponseBaseDTO> responseError(Integer codigo, String message) {
        return new ResponseEntity<>(
                new ResponseBaseDTO(MessageError.OPERACION_ERRONEA, codigo, message, StringUtils.EMPTY),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseBaseDTO> handleException(Exception ex) {
        logger.logErrorAppLogger(ex.getMessage(), ex);
        Integer codigo;
        if (ex instanceof AuthenticationException) {
            if (ex.getClass() == UsernameNotFoundException.class) {
                codigo = MessageError.ERROR_CUENTA_SIN_PERMISOS;
            } else if (ex.getClass() == BadCredentialsException.class) {
                codigo = MessageError.ERROR_CLAVE_ERRONEA;
            } else {
                codigo = MessageError.ERROR_CUENTA_SIN_PERMISOS;
            }
        } else {
            codigo = MessageError.ERROR_GENERICO;
        }
        String message = env.getProperty(MessageError.getPropertyMessage(codigo));
        return responseError(codigo, message);
    }

    @ExceptionHandler(RESTException.class)
    public ResponseEntity<ResponseBaseDTO> handleException(RESTException ex) {
        String message;
        if (ex.getMessage() == null || ex.getMessage().isEmpty()) {
            message = env.getProperty(MessageError.getPropertyMessage(ex.getCodigo()));
        } else {
            message = ex.getMessage();
        }
        logger.logErrorAppLogger(message, ex.getEx());
        return responseError(ex.getCodigo(), message);
    }

}
