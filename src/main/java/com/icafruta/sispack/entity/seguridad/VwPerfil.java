package com.icafruta.sispack.entity.seguridad;

import com.icafruta.sispack.dto.MenuDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by alxnderq on 11/22/2016.
 */
@Entity
@Table(name = "vw_perfil", schema = "seguridad")
public class VwPerfil implements Serializable {

    private static final long serialVersionUID = -7118379556643681401L;
    @Id
    @Column(name = "id_asnc_pfil")
    private Integer id;
    @Column(name = "id_mnu")
    private Integer idMenu;
    @Size(max = 150)
    @Column(name = "nbre_mnu")
    private String nombreMenu;
    @Size(max = 150)
    @Column(name = "elce_mnu")
    private String urlMenu;
    @Size(max = 30)
    @Column(name = "icno_mnu")
    private String iconoMenu;
    @Column(name = "id_pdre_mnu")
    private Integer idPadreMenu;
    @Column(name = "tpo_mnu")
    private Integer tipoMenu;
    @Column(name = "nvel_mnu")
    private Integer nivelMenu;
    @Size(max = 40)
    @Column(name = "cse_mnu")
    private String managedbeanMenu;
    @Column(name = "etdo_mnu")
    private Integer estadoMenu;
    @Column(name = "oden_mnu")
    private Integer ordenMenu;
    @Column(name = "id_pfil")
    private Integer idPerfil;
    @Column(name = "etdo_asnc_pfil")
    private boolean estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public String getIconoMenu() {
        return iconoMenu;
    }

    public void setIconoMenu(String iconoMenu) {
        this.iconoMenu = iconoMenu;
    }

    public Integer getIdPadreMenu() {
        return idPadreMenu;
    }

    public void setIdPadreMenu(Integer idPadreMenu) {
        this.idPadreMenu = idPadreMenu;
    }

    public Integer getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(Integer tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public Integer getNivelMenu() {
        return nivelMenu;
    }

    public void setNivelMenu(Integer nivelMenu) {
        this.nivelMenu = nivelMenu;
    }

    public String getManagedbeanMenu() {
        return managedbeanMenu;
    }

    public void setManagedbeanMenu(String managedbeanMenu) {
        this.managedbeanMenu = managedbeanMenu;
    }

    public Integer getEstadoMenu() {
        return estadoMenu;
    }

    public void setEstadoMenu(Integer estadoMenu) {
        this.estadoMenu = estadoMenu;
    }

    public Integer getOrdenMenu() {
        return ordenMenu;
    }

    public void setOrdenMenu(Integer ordenMenu) {
        this.ordenMenu = ordenMenu;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public MenuDTO toMenuDTO(){
        MenuDTO dto = new MenuDTO();
        dto.setId(this.idMenu);
        dto.setNombre(this.nombreMenu);
        dto.setUrl(this.urlMenu);
        dto.setIcono(this.iconoMenu);
        dto.setTipo(this.tipoMenu);
        dto.setNivel(this.nivelMenu);
        dto.setManagedbean(this.managedbeanMenu);
        dto.setOrden(this.ordenMenu);
        dto.setEstado(this.estado);
        return dto;
    }
}
