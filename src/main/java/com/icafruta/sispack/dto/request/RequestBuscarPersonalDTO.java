package com.icafruta.sispack.dto.request;

import com.icafruta.sispack.dto.BuscarPersonalDTO;
import com.icafruta.sispack.dto.PaginationDTO;

import java.io.Serializable;

/**
 * Created by alxnderq on 12/12/2016.
 */
public class RequestBuscarPersonalDTO implements Serializable {

    private BuscarPersonalDTO data;
    private PaginationDTO pagination;

    public BuscarPersonalDTO getData() {
        return data;
    }

    public void setData(BuscarPersonalDTO data) {
        this.data = data;
    }

    public PaginationDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationDTO pagination) {
        this.pagination = pagination;
    }
}
