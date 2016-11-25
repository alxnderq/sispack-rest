package com.icafruta.sispack.dto;

import com.icafruta.sispack.entity.administracion.Parametro;

import java.io.Serializable;

/**
 * Created by alxnderq on 11/25/2016.
 */
public class ParametroDTO implements Serializable {

    private Integer id;
    private String grupo;
    private String codigo;
    private String valor;
    private Integer idPadre;
    private Integer orden;
    private boolean estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
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

    Parametro toParametro(){
        Parametro parametro = new Parametro();
        parametro.setId(this.id);
        parametro.setGrupo(this.grupo);
        parametro.setCodigo(this.codigo);
        parametro.setValor(this.valor);
        parametro.setIdPadre(this.idPadre);
        parametro.setOrden(this.orden);
        parametro.setEstado(this.estado);
        return parametro;
    }
}
