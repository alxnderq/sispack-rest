package com.icafruta.sispack.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by alxnderq on 13/11/2016.
 */
public class PropertiesLoader {

    public Properties load(String fileName) {
        Properties prop = new Properties();
        InputStream im = null;
        try {
            im = findFile(fileName);
            prop.load(im);
        } catch (IOException ignore) {
        } finally {
            if (im != null) {
                try {
                    im.close();
                } catch (IOException ignore) {
                }
            }
        }
        return prop;
    }

    private InputStream findFile(String fileName) throws FileNotFoundException {
        InputStream im = findInWorkingDirectory(fileName);
        if (im == null)
            im = findInClasspath(fileName);
        if (im == null)
            im = findInSourceDirectory(fileName);
        if (im == null)
            throw new FileNotFoundException(String.format("File %s not found", fileName));
        return im;
    }

    private InputStream findInSourceDirectory(String fileName) throws FileNotFoundException {
        return new FileInputStream("src/pe/com/mibanco/sige/resources/" + fileName);
    }

    private InputStream findInClasspath(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    }

    private InputStream findInWorkingDirectory(String fileName) {
        try {
            return new FileInputStream(System.getProperty("user.dir") + fileName);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
