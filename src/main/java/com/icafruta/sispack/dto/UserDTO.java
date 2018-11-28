package com.icafruta.sispack.dto;

import java.io.Serializable;

/**
 * Created by alxnderq on 13/11/2016.
 */
public class UserDTO implements Serializable{

    private static final long serialVersionUID = 7838260792148421832L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
