package com.main.codigo_fuente.app.backend.database;

import com.main.codigo_fuente.app.backend.suscripcion.Suscripcion;
import java.sql.*;

import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import java.time.LocalDate;

public class ClaseDBSuscripcion extends ConectionDB {

    public ClaseDBSuscripcion() {
        super();
    }
    
    public ResultSet selectSuscripciones(String nombreRevista) {
        String select = "SELECT * FROM suscripción WHERE nombre_revista = '" + nombreRevista + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }
    
    public ResultSet selectSuscripcion(String nombreRevista, String nombreSuscriptor) {
        String select = "SELECT * FROM suscripción WHERE nombre_revista = '" + nombreRevista + "' AND nombre_suscriptor = '" + nombreSuscriptor +"';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertSuscripcion(Suscripcion suscripcion) {
        String insert = "INSERT INTO suscripción (nombre_revista, nombre_suscriptor, fecha_suscripción) "
                + "values('" + suscripcion.getNombreRevista() + "','" + suscripcion.getNombreSuscriptor() + "','"
                + suscripcion.getFechaSuscripcion().toString() + "');";

        insertData(insert);
    }
}
