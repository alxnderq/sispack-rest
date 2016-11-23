package com.icafruta.sispack.dto;

import com.icafruta.sispack.entity.administracion.Personal;

import java.util.List;

/**
 * Created by alxnderq on 11/16/2016.
 */
public class PersonalDTO {

    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private boolean estado;
    private List<PerfilDTO> perfiles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<PerfilDTO> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilDTO> perfiles) {
        this.perfiles = perfiles;
    }
}
