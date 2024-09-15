package com.main.codigo_fuente.app.backend.archivo;

import java.io.*;

public class Archivo {

    public File inputStreamToFile(InputStream inputStream) {
        File file = null;
        try {
            file = File.createTempFile("image", ".pgn");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            inputStream.transferTo(outputStream);
        } catch (Exception e) {
        }

        return file;
    }
}
