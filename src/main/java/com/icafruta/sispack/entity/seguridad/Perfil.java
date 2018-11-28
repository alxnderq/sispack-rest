package com.icafruta.sispack.entity.seguridad;

import com.icafruta.sispack.dto.PerfilDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Entity
@Table(name = "perfil", schema = "seguridad")
public class Perfil implements Serializable {

    private static final long serialVersionUID = -7039187223105765316L;
    @Id
    @Column(name = "id_pfil")
    private Integer id;
    @Column(name = "nbre_pfil")
    private String nombre;
    @Column(name = "etdo_pfil")
    private boolean estado;

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

    public PerfilDTO toPerfilDTO(){
        PerfilDTO dto = new PerfilDTO();
        dto.setId(this.id);
        dto.setNombre(this.nombre);
        dto.setEstado(this.estado);
        return dto;
    }
}
