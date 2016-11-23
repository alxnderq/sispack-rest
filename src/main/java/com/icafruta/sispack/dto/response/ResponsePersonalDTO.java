package com.icafruta.sispack.dto.response;

import com.icafruta.sispack.dto.PersonalDTO;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class ResponsePersonalDTO extends ResponseBaseDTO {

    private PersonalDTO usuario;

    public PersonalDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(PersonalDTO usuario) {
        this.usuario = usuario;
    }
}
