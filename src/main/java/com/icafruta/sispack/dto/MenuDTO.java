package com.icafruta.sispack.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class MenuDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String url;
    private String icono;
    private Integer tipo;
    private Integer nivel;
    private String managedbean;
    private Integer orden;
    private boolean estado;
    private List<MenuDTO> submenu;

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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<MenuDTO> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<MenuDTO> submenu) {
        this.submenu = submenu;
    }
}
