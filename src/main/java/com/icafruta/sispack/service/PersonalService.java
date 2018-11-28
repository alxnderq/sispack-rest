package com.icafruta.sispack.service;

import java.util.List;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.request.RequestBuscarPersonalDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.exceptions.RESTException;

/**
 * Created by alxnderq on 11/24/2016.
 */
public interface PersonalService {

    List<PersonalDTO> find(RequestBuscarPersonalDTO dto) throws RESTException;

    void save(Personal personal) throws RESTException;
}
