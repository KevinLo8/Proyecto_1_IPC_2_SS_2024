package com.main.codigo_fuente.app.backend.anuncio;

import java.io.*;

import com.main.codigo_fuente.app.backend.database.ClaseDBAnuncio;

public class CreadorAnuncio {

    private final ClaseDBAnuncio db = new ClaseDBAnuncio();

    public void crearAnuncio(Anuncio anuncio, File data, String texto) {

        anuncio.completarReq(data, texto);

        db.insertAnuncio(anuncio);
        db.cerrarDB();
    }

}
