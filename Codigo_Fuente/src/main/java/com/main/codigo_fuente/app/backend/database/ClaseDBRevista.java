package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

import com.main.codigo_fuente.app.backend.revista.Revista;

public class ClaseDBRevista extends ConectionDB {

    public ClaseDBRevista() {
        super();
    }
    
    public ResultSet selectRevista(String nombreRevista) {
        String select = "SELECT * FROM anuncio WHERE nombre_revista = '" + nombreRevista + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertRevista(Revista revista) {
        String insert = "INSERT INTO revista (nombre_revista, usuario_publicador, data_revista, precio_suscripcion) "
                + "values('" + revista.getNombreRevista() + "','" + revista.getUsuarioPublicador() + "','"
                + revista.getArchivoRevista() + "','" + revista.getPrecioRevista() + "');";

        insertData(insert);
    }
}

