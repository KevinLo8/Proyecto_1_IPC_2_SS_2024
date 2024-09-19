/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.suscripcion;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class Suscripciones {

    public Suscripcion[] pedirSuscripciones(ResultSet res) {
        Suscripcion[] suscripcionesOut = new Suscripcion[0];

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
        return suscripcionesOut;
    }
}
