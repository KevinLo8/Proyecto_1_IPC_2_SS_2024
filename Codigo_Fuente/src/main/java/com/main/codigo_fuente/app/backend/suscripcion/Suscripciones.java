/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.suscripcion;

import com.main.codigo_fuente.app.backend.database.ClaseDBSuscripcion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class Suscripciones {

    public Suscripcion[] pedirSuscripciones(String nombreRevista) {
        Suscripcion[] suscripcionesOut = new Suscripcion[0];

        ClaseDBSuscripcion db = new ClaseDBSuscripcion();
        ResultSet res = db.selectSuscripciones(nombreRevista);

        try {
            while (res.next()) {
                Suscripcion[] suscripciones = new Suscripcion[suscripcionesOut.length + 1];

                for (int i = 0; i < suscripcionesOut.length; i++) {
                    suscripciones[i] = suscripcionesOut[i];

                }

                Suscripcion suscripcion = new Suscripcion();
                suscripcion.crearRes(res);

                if (suscripcion.estaActiva()) {
                    suscripciones[suscripcionesOut.length] = suscripcion;
                    suscripcionesOut = suscripciones;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        db.cerrarDB();

        return suscripcionesOut;
    }
}
