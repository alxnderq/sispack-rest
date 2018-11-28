package com.icafruta.sispack.dto.response;

import com.icafruta.sispack.dto.PersonalDTO;

import java.util.List;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class ResponseListaPersonalDTO extends ResponseBaseDTO {

    private static final long serialVersionUID = 1297156482585726550L;
    private List<PersonalDTO> lista;

    public List<PersonalDTO> getLista() {
        return lista;
    }

    public void setLista(List<PersonalDTO> lista) {
        this.lista = lista;
    }
}
