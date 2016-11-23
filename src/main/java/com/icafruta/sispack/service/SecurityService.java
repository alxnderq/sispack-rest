package com.icafruta.sispack.service;

import com.icafruta.sispack.dto.MenuDTO;
import com.icafruta.sispack.dto.PerfilDTO;
import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.UserDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.exceptions.RESTException;

import java.util.List;

/**
 * Created by alxnderq on 13/11/2016.
 */
public interface SecurityService {

    List<PersonalDTO> findAll();

    Personal findByUser(String user);

    List<PerfilDTO> findProfile(Integer id);

}
