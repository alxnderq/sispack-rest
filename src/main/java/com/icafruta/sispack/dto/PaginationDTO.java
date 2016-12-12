package com.icafruta.sispack.dto;

import java.io.Serializable;

/**
 * Created by alxnderq on 12/12/2016.
 */
public class PaginationDTO implements Serializable {

    private int page;
    private int size;
    private String[] properties;

    public int getPage() {
        return page - 1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }
}
