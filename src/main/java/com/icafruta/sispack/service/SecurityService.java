package com.icafruta.sispack.service;

import java.util.List;

import com.icafruta.sispack.dto.PerfilDTO;
import com.icafruta.sispack.entity.administracion.Personal;

/**
 * Created by alxnderq on 13/11/2016.
 */
public interface SecurityService {

    Personal findByUser(String user);

    List<PerfilDTO> findProfile(Integer id);

}
