package com.icafruta.sispack.dto;

import com.icafruta.sispack.entity.administracion.Personal;

import java.io.Serializable;

/**
 * Created by alxnderq on 12/12/2016.
 */
public class BuscarPersonalDTO implements Serializable {

    private String codigo;
    private String apellido;
    private String nombre;
    private boolean estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Personal toPersonal(){
        Personal personal = new Personal();
        personal.setId(codigo != null ? (!this.codigo.trim().isEmpty() ? this.codigo.toUpperCase() : null) : null);
        personal.setNombre(this.nombre);
        personal.setApellido(this.apellido);
        personal.setEstado(this.estado);
        return personal;
    }
}
