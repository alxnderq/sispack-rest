package com.icafruta.sispack.security.providers;

import com.icafruta.sispack.dto.LoginDTO;
import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.service.SecurityService;
import com.icafruta.sispack.utils.Encrypt;
import com.icafruta.sispack.utils.MessageError;
import com.icafruta.sispack.utils.RESTConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class RESTAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SecurityService service;

    @Autowired
    Environment env;

    @Value("${configuration.default.password}")
    String defaultPassword;

    @Value("${configuration.authentication}")
    Integer loginType;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String password = Encrypt.encriptar(authentication.getCredentials().toString(), Encrypt.HASH_SHA1);
        final String genericPassword = Encrypt.encriptar(defaultPassword, Encrypt.HASH_SHA1);

        Personal p = service.findByUser(username);
        if (p != null){
            LoginDTO dto = new LoginDTO(p.toPersonalDTO(), service.findProfile(p.getIdPerfil()));
            if (loginType.equals(RESTConstants.LOGIN_BD)){
                if (p.getPassword().compareTo(password) == 0) {
                    return authUser(dto, password);
                } else {
                    throw new BadCredentialsException(env.getProperty(MessageError.getPropertyMessage(MessageError.ERROR_CLAVE_ERRONEA)));
                }
            } else if (loginType.equals(RESTConstants.LOGIN_GENERIC_PASSWORD)){
                if (password.compareTo(genericPassword) == 0) {
                    return authUser(dto, password);
                } else {
                    throw new BadCredentialsException(env.getProperty(MessageError.getPropertyMessage(MessageError.ERROR_CLAVE_ERRONEA)));
                }
            } else {
                return authUser(dto, password);
            }
        } else {
            throw new UsernameNotFoundException(env.getProperty(MessageError.getPropertyMessage(MessageError.ERROR_CUENTA_SIN_PERMISOS)));
        }
    }

    private Authentication authUser(LoginDTO data, String password) {
        RESTUserDetails userDetails = RESTUserDetailsFactory.create(data);
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
