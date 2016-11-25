package com.icafruta.sispack.controller;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.dto.response.ResponseBaseDTO;
import com.icafruta.sispack.dto.response.ResponseListaPersonalDTO;
import com.icafruta.sispack.exceptions.RESTException;
import com.icafruta.sispack.service.PersonalService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alxnderq on 11/24/2016.
 */
@RestController
public class PersonalController extends BaseController {

    @Autowired
    private PersonalService service;

    @RequestMapping(value = "/personal/find/", method = RequestMethod.POST)
    public ResponseEntity<ResponseListaPersonalDTO> find(Pageable pageable, HttpServletRequest request) throws RESTException{
        ResponseListaPersonalDTO response = new ResponseListaPersonalDTO();
        response.setLista(service.find(pageable));
        return responseData(response, request);
    }

    @RequestMapping(value = "/personal/save/", method = RequestMethod.POST)
    public ResponseEntity<ResponseBaseDTO> save(@RequestBody PersonalDTO dto, HttpServletRequest request) throws RESTException{
        ResponseBaseDTO response = new ResponseBaseDTO();
        service.save(dto.toPersonal());
        return responseData(response, request);
    }
}
