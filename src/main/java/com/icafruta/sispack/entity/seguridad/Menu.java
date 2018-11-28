package com.icafruta.sispack.entity.seguridad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Entity
@Table(name = "menu", schema = "seguridad")
public class Menu implements Serializable {

    private static final long serialVersionUID = -2215561972626960837L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mnu")
    private Integer id;
    @Size(max = 150)
    @Column(name = "nbre_mnu")
    private String nombre;
    @Size(max = 150)
    @Column(name = "elce_mnu")
    private String url;
    @Size(max = 30)
    @Column(name = "icno_mnu")
    private String icono;
    @Column(name = "id_pdre_mnu")
    private Integer idPadre;
    @Column(name = "tpo_mnu")
    private Integer tipo;
    @Column(name = "nvel_mnu")
    private Integer nivel;
    @Size(max = 40)
    @Column(name = "cse_mnu")
    private String managedbean;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etdo_mnu")
    private Integer estado;
    @Column(name = "oden_mnu")
    private Integer orden;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getManagedbean() {
        return managedbean;
    }

    public void setManagedbean(String managedbean) {
        this.managedbean = managedbean;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
