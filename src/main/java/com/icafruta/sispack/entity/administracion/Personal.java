package com.icafruta.sispack.entity.administracion;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.entity.seguridad.Perfil;
import com.icafruta.sispack.utils.converter.BooleanNumericConverter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alxnderq on 12/11/2016.
 */
@Entity
@Table(name = "personal", schema = "administracion")
public class Personal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Size(max = 6)
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
    @Column(name = "id_pfil")
    private Integer idPerfil;
    @JoinColumn(name = "id_cgo", referencedColumnName = "id_prmtro")
    @ManyToOne
    private Parametro cargo;
    @Convert(converter = BooleanNumericConverter.class)
    @Column(name = "etdo_psnal")
    private Boolean estado;
    @Convert(converter = BooleanNumericConverter.class)
    @Column(name = "etdo_usrio_psnal")
    private Boolean estadoUsuario;

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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Parametro getCargo() {
        return cargo;
    }

    public void setCargo(Parametro cargo) {
        this.cargo = cargo;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public PersonalDTO toPersonalDTO(){
        PersonalDTO dto = new PersonalDTO();
        dto.setId(this.id);
        dto.setNombre(this.nombre);
        dto.setApellido(this.apellido);
        dto.setDni(this.dni);
        dto.setCorreo(this.correo);
        dto.setUsuario(this.usuario);
        dto.setCargo(this.cargo != null ? this.cargo.toParametroDTO() : null);
        dto.setEstado(this.estado);
        dto.setEstadoUsuario(this.estadoUsuario);
        return dto;
    }
}
