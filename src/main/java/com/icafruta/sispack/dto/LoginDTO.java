package com.icafruta.sispack.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by alxnderq on 11/24/2016.
 */
public class LoginDTO implements Serializable{

    private static final long serialVersionUID = 3776012697730375276L;
    private PersonalDTO personal;
    private List<PerfilDTO> perfiles;

    public LoginDTO(){

    }

    public LoginDTO(PersonalDTO personal, List<PerfilDTO> perfiles) {
        this.personal = personal;
        this.perfiles = perfiles;
    }

    public PersonalDTO getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalDTO personal) {
        this.personal = personal;
    }

    public List<PerfilDTO> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilDTO> perfiles) {
        this.perfiles = perfiles;
    }
}
