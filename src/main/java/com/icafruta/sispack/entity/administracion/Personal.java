package com.icafruta.sispack.entity.administracion;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.entity.seguridad.Perfil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alxnderq on 12/11/2016.
 */
@Entity
@Table(name = "personal", schema = "administracion")
public class Personal implements Serializable{

    @Id
    @Column(name = "id_psnal")
    private String id;
    @Column(name = "nbre_psnal")
    private String nombre;
    @Column(name = "aplldo_psnal")
    private String apellido;
    @Column(name = "dni_psnal")
    private String dni;
    @Column(name = "crro_psnal")
    private String correo;
    @Column(name = "usrio_psnal")
    private String usuario;
    @Column(name = "cve_psnal")
    private String password;
    @Column(name = "etdo_psnal")
    private boolean estado;
    @Column(name = "id_pfil")
    private Integer idPerfil;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public PersonalDTO toPersonalDTO(){
        PersonalDTO dto = new PersonalDTO();
        dto.setId(this.id);
        dto.setNombre(this.nombre);
        dto.setApellido(this.apellido);
        dto.setDni(this.dni);
        dto.setCorreo(this.correo);
        dto.setUsuario(this.usuario);
        dto.setEstado(this.estado);
        return dto;
    }
}
