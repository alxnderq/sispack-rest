package com.icafruta.sispack.exceptions;

import java.io.Serializable;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class RESTException extends Exception implements Serializable{

    private int codigo;
    private Exception ex;
    private String message;

    public RESTException(int codigo, Exception ex) {
        super();
        this.codigo = codigo;
        this.ex = ex;
    }

    public RESTException(int codigo) {
        super();
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
