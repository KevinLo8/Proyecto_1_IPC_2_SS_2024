package com.main.codigo_fuente.app.backend.archivo;

import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.*;

public class Archivo {

    public File inputStreamToFile(InputStream inputStream, String nombre, String extencion) {
        File file = null;
        try {
            file = File.createTempFile(nombre, extencion);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            inputStream.transferTo(outputStream);
        } catch (Exception e) {
        }

        return file;
    }

    public InputStream extraerInputStream(HttpServletRequest req, String archivo) throws ServletException, IOException, DataErrorException {

        Part filepart = req.getPart(archivo);
        InputStream inputStream = null;

        if (filepart != null) {
            inputStream = filepart.getInputStream();
        } else {
            throw new DataErrorException();
        }

        return inputStream;
    }

}
