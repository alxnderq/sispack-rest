package com.icafruta.sispack.dto.response;

import java.io.Serializable;

/**
 * Created by alxnderq on 13/11/2016.
 */
public class ResponseBaseDTO implements Serializable {

    private Integer operacion;
    private Integer codigo;
    private String mensaje;
    private String token;

    public ResponseBaseDTO() {

    }

    public ResponseBaseDTO(Integer operacion, Integer codigo, String mensaje, String token) {
        setOperacion(operacion);
        setCodigo(codigo);
        setMensaje(mensaje);
        setToken(token);
    }

    public Integer getOperacion() {
        return operacion;
    }

    public void setOperacion(Integer operacion) {
        this.operacion = operacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
