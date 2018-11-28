package com.icafruta.sispack.entity.administracion;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.entity.seguridad.Perfil;
import com.icafruta.sispack.utils.converter.BooleanNumericConverter;

/**
 * Created by alxnderq on 12/11/2016.
 */
@Entity
@Table(name = "personal", schema = "administracion")
public class Personal implements Serializable{

    private static final long serialVersionUID = -721128923496659155L;
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
    @JoinColumn(name = "id_pfil", referencedColumnName = "id_pfil")
    @ManyToOne
    private Perfil perfil;
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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
