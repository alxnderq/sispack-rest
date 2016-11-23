package com.icafruta.sispack.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class PerfilDTO implements Serializable{

    private Integer id;
    private String nombre;
    private boolean estado;
    private List<MenuDTO> listaMenu;

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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<MenuDTO> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<MenuDTO> listaMenu) {
        this.listaMenu = listaMenu;
    }
}
