package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

import com.main.codigo_fuente.app.backend.anuncio.Anuncio;

public class ClaseDBAnuncio extends ConectionDB {

    public ClaseDBAnuncio() {
        super();
    }
    
    public ResultSet selectAnuncio(int id) {
        String select = "SELECT * FROM anuncio WHERE id = '" + id + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertAnuncio(Anuncio anuncio) {
        String insert = "INSERT INTO anuncio (id, usuario_comprador, tipo_anuncio, duracion_anuncio, fecha_activación, data_anuncio, texto, anuncio) "
                + "values('" + anuncio.getId() + "','" + anuncio.getUsuarioComprador() + "','"
                + anuncio.getTipoAnuncio() + "','" + anuncio.getDuracionAnuncio() + "','"
                + anuncio.getFechaActivacion().toString() + "','" + anuncio.getDataAnuncio() + "','"
                + anuncio.getTextoAnuncio() + "');";

        insertData(insert);
    }
}

