package com.icafruta.sispack.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by alxnderq on 13/11/2016.
 */
@Component
public class LoggerService {

    private static final Logger loggerApp = LogManager.getLogger("REST-Logger");

    public void logDebugAppLoger(String mensaje) {
        if (loggerApp.isDebugEnabled()) {
            loggerApp.debug(mensaje);
        }
    }

    public void logTraceAppLoger(String mensaje) {
        if (loggerApp.isTraceEnabled()) {
            loggerApp.trace(mensaje);
        }
    }

    public void logInfoAppLogger(String mensaje) {
        if (loggerApp.isInfoEnabled()) {
            loggerApp.info(mensaje);
        }
    }

    public void logErrorAppLogger(String mensaje, Throwable exception) {
        loggerApp.error(mensaje, exception);
    }

    public void logErrorAppLogger(String mensaje) {
        loggerApp.error(mensaje);
    }
}
