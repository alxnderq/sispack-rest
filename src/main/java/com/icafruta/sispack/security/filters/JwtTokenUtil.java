package com.icafruta.sispack.security.filters;

import com.google.gson.Gson;
import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.security.providers.RESTUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final String CONTRACT_KEY_USER = "user";
    private static final String CONTRACT_KEY_CREATED = "created";
    private static final String CONTRACT_KEY_USER_DATA = "userData";

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private String expiration;

    public String getUserToken(String token) {
        String username;
        try {
            final Claims contract = getContractToken(token);
            username = (String) contract.get(CONTRACT_KEY_USER);
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getDateCreatedToken(String token) {
        Date created;
        try {
            final Claims contract = getContractToken(token);
            created = new Date((Long) contract.get(CONTRACT_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public PersonalDTO getPersonalDTO(String token) {
        PersonalDTO dto;
        try {
            final Claims contract = getContractToken(token);
            dto = new Gson().fromJson((String) contract.get(CONTRACT_KEY_USER_DATA), PersonalDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            dto = null;
        }
        return dto;
    }

    public Date getExpiredDateToken(String token) throws ExpiredJwtException {
        Date expiration;
        try {
            final Claims claims = getContractToken(token);
            expiration = claims.getExpiration();
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getContractToken(String token) throws ExpiredJwtException {
        Claims contract;
        try {
            contract = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            contract = null;
        }
        return contract;
    }

    private Date generateExpiredDate() {
        return new Date(System.currentTimeMillis() + new Long(expiration) * 1000);
    }

    public Boolean isExpiredToken(String token) {
        try {
            final Date expiration = getExpiredDateToken(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getToken(PersonalDTO dto) {
        Map<String, Object> contract = new HashMap<>();
        contract.put(CONTRACT_KEY_USER, dto.getUsuario());
        contract.put(CONTRACT_KEY_CREATED, new Date());
        contract.put(CONTRACT_KEY_USER_DATA, new Gson().toJson(dto));
        return generateToken(contract);
    }

    private String generateToken(Map<String, Object> contract) {
        return Jwts.builder().setClaims(contract).setExpiration(generateExpiredDate())
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean isRefreshedToken(String token) {
        try {
            return !isExpiredToken(token);
        } catch (Exception e) {
            return false;
        }
    }

    public String refreshToken(String token) {
        String newToken;
        try {
            final Claims contract = getContractToken(token);
            contract.put(CONTRACT_KEY_CREATED, new Date());
            newToken = generateToken(contract);
        } catch (Exception e) {
            newToken = null;
        }
        return newToken;
    }

    public String updateTokenController(String token) {
        if (isRefreshedToken(token)) {
            String refreshedToken = refreshToken(token);
            return refreshedToken;
        } else {
            return null;
        }
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        RESTUserDetails user = (RESTUserDetails) userDetails;
        final String username = getUserToken(token);
        return (username.equals(user.getUsername()));
    }

}
