package com.icafruta.sispack.security.providers;

import java.util.ArrayList;
import java.util.List;

import com.icafruta.sispack.dto.LoginDTO;
import com.icafruta.sispack.dto.PerfilDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Created by alxnderq on 11/22/2016.
 */
public final class RESTUserDetailsFactory {

    public RESTUserDetailsFactory() {
    }

    public static RESTUserDetails create(LoginDTO data) {
        return new RESTUserDetails(data, mapToGrantedAuthorities(data.getPerfiles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<PerfilDTO> profiles) {
        List<GrantedAuthority> listGranted = new ArrayList<>();
        if (profiles != null && !profiles.isEmpty()) {
            ArrayList<Integer> listaIds = new ArrayList<>();
            for (PerfilDTO profile : profiles) {
                if (!listaIds.contains(profile.getId())) {
                    listaIds.add(profile.getId());
                    GrantedAuthority granted = new SimpleGrantedAuthority(profile.getNombre());
                    listGranted.add(granted);
                }
            }
        }
        return listGranted;
    }
}
