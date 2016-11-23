package com.icafruta.sispack.security.providers;

import com.icafruta.sispack.dto.PerfilDTO;
import com.icafruta.sispack.dto.PersonalDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alxnderq on 11/22/2016.
 */
public final class RESTUserDetailsFactory {

    public RESTUserDetailsFactory() {
    }

    public static RESTUserDetails create(PersonalDTO data) {
        return new RESTUserDetails(data, mapToGrantedAuthorities(data.getPerfiles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<PerfilDTO> perfiles) {
        List<GrantedAuthority> listGranted = new ArrayList<>();
        if (perfiles != null && !perfiles.isEmpty()) {
            ArrayList<Integer> listaIds = new ArrayList<>();
            for (PerfilDTO perfil : perfiles) {
                if (!listaIds.contains(perfil.getId())) {
                    listaIds.add(perfil.getId());
                    GrantedAuthority granted = new SimpleGrantedAuthority(perfil.getNombre());
                    listGranted.add(granted);
                }
            }
        }
        return listGranted;
    }
}
