package com.icafruta.sispack.service.impl;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.request.RequestBuscarPersonalDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.exceptions.RESTException;
import com.icafruta.sispack.repository.PersonalRepository;
import com.icafruta.sispack.service.PersonalService;
import com.icafruta.sispack.utils.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alxnderq on 11/24/2016.
 */
@Service
public class PersonalServiceImpl extends BaseServiceImpl implements PersonalService {

    @Autowired
    private PersonalRepository repository;

    @Override
    public List<PersonalDTO> find(RequestBuscarPersonalDTO dto) throws RESTException{
        try {
            List<PersonalDTO> listPersonal = new ArrayList<>();
            Page<Personal> page = repository.findAll(pageable(dto.getPagination()));
            if (page != null && page.hasContent()) {
                List<Personal> list = page.getContent();
                list.forEach(personal -> listPersonal.add(personal.toPersonalDTO()));
            }
            return listPersonal;
        } catch (Exception e) {
            throw new RESTException(MessageError.ERROR_PERSONAL_LIST, e);
        }
    }

    @Override
    public void save(Personal personal) throws RESTException{
        try {
            repository.save(personal);
        } catch (Exception e){
            throw new RESTException(MessageError.ERROR_PERSONAL_SAVE, e);
        }
    }
}
