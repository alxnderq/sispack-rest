package com.icafruta.sispack.dto.response;

import com.icafruta.sispack.dto.LoginDTO;

/**
 * Created by alxnderq on 11/22/2016.
 */
public class ResponseLoginDTO extends ResponseBaseDTO {

    private LoginDTO data;

    public LoginDTO getData() {
        return data;
    }

    public void setData(LoginDTO data) {
        this.data = data;
    }
}
