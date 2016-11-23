package com.icafruta.sispack.utils;

/**
 * Created by alxnderq on 13/11/2016.
 */
public class MessageError {

    public static String getPropertyMessage(int codigo) {
        return SISPACK_ERROR + codigo;
    }

    private static String SISPACK_ERROR = "sispack.error.";

    public static int ERROR_GENERICO = -9999;

    public static int OPERACION_EXITOSA = 1;
    public static int OPERACION_ERRONEA = 0;
    public static int ERROR_CLAVE_ERRONEA = -1001;
    public static int ERROR_CUENTA_NO_EXISTE = -1002;
    public static int ERROR_CUENTA_SIN_PERMISOS = -1003;
    public static int ERROR_CUENTA_SIN_ROL = -1004;
    public static int ERROR_SESION_EXPIRADO = -1005;
}
