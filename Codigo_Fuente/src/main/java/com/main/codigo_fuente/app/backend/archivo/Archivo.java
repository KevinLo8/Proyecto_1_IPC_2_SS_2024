package com.main.codigo_fuente.app.backend.archivo;

import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.*;

@MultipartConfig(location = "/tmp")
public class Archivo {

    public InputStream extraerInputStream(HttpServletRequest req, String archivo) throws ServletException, IOException, DataErrorException {

        Part filepart = req.getPart(archivo);

        if (filepart != null) {
            return filepart.getInputStream();
        } else {
            throw new DataErrorException();
        }
    }

    public String extraerNombreArchivo(HttpServletRequest req, String archivo) throws ServletException, IOException, DataErrorException {

        Part filepart = req.getPart(archivo);

        if (filepart != null) {
            return filepart.getSubmittedFileName();
        } else {
            throw new DataErrorException();
        }

    }

    public String extraerExtencionArchivo(HttpServletRequest req, String archivo) throws ServletException, IOException, DataErrorException {

        Part filepart = req.getPart(archivo);

        if (filepart != null) {
            return filepart.getContentType();
        } else {
            throw new DataErrorException();
        }
    }

}
