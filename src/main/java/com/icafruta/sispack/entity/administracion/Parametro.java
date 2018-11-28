package com.icafruta.sispack.entity.administracion;

import com.icafruta.sispack.dto.ParametroDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by alxnderq on 11/25/2016.
 */
@Entity
@Table(name = "parametro", schema = "administracion")
public class Parametro implements Serializable {

    private static final long serialVersionUID = 7262220898719286231L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prmtro")
    private Integer id;
    @Size(max = 40)
    @Column(name = "gpo_prmtro")
    private String grupo;
    @Size(max = 40)
    @Column(name = "cdgo_prmtro")
    private String codigo;
    @Size(max = 40)
    @Column(name = "vlor_prmtro")
    private String valor;
    @Column(name = "id_pdre_prmtro")
    private Integer idPadre;
    @Column(name = "oden_prmtro")
    private Integer orden;
    @Column(name = "etdo_prmtro")
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

    ParametroDTO toParametroDTO(){
        ParametroDTO dto = new ParametroDTO();
        dto.setId(this.id);
        dto.setGrupo(this.grupo);
        dto.setCodigo(this.codigo);
        dto.setValor(this.valor);
        dto.setIdPadre(this.idPadre);
        dto.setOrden(this.orden);
        dto.setEstado(this.estado);
        return dto;
    }
}
