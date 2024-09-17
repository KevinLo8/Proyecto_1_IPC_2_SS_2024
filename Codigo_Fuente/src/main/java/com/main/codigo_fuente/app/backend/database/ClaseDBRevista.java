package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

import com.main.codigo_fuente.app.backend.revista.Revista;

public class ClaseDBRevista extends ConectionDB {

    public ClaseDBRevista() {
        super();
    }

    public ResultSet selectRevista(String nombreRevista) {
        String select = "SELECT * FROM revista WHERE nombre_revista = '" + nombreRevista + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public ResultSet selectRevistas() {
        String select = "SELECT nombre_revista, usuario_publicador, precio_suscripcion FROM revista;";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertRevista(Revista revista) {
        String insert = "INSERT INTO revista (nombre_revista, usuario_publicador,"
                + "data_revista, nombre_archivo, extencion_archivo, precio_suscripcion) "
                + "values('" + revista.getNombreRevista() + "','" + revista.getUsuarioPublicador() + "','"
                + revista.getArchivoRevista() + "','" + revista.getNombreArchivo() + "','"
                + revista.getExtencionArchivo() + "','" + revista.getPrecioRevista() + "');";

        insertData(insert);
    }

    public void updatePrecioRevista(String nombreRevista, Double precio) {
        String update = "UPDATE revista SET precio_suscripcion = '" + precio + "' WHERE nombre_revista = '" + nombreRevista + "';";
        
        insertData(update);
    }

}
