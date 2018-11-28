package com.icafruta.sispack.dto;

import java.io.Serializable;

import com.icafruta.sispack.entity.administracion.Personal;

/**
 * Created by alxnderq on 11/16/2016.
 */
public class PersonalDTO implements Serializable{

    private static final long serialVersionUID = 3216701830304844548L;
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private PerfilDTO perfil;
    private ParametroDTO cargo;
    private Boolean estado;
    private Boolean estadoUsuario;

    public PersonalDTO(){
        estado = true;
        estadoUsuario = false;
    }

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }

    public ParametroDTO getCargo() {
        return cargo;
    }

    public void setCargo(ParametroDTO cargo) {
        this.cargo = cargo;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Personal toPersonal(){
        Personal personal = new Personal();
        personal.setId(id != null ? (!id.trim().isEmpty() ? id.toUpperCase() : null) : null);
        personal.setNombre(this.nombre);
        personal.setApellido(this.apellido);
        personal.setDni(this.dni);
        personal.setCorreo(this.correo);
        personal.setUsuario(this.usuario);
        personal.setCargo(this.cargo != null ? this.cargo.toParametro() : null);
        personal.setEstado(this.estado);
        personal.setEstadoUsuario(this.estadoUsuario);
        return personal;
    }

}
