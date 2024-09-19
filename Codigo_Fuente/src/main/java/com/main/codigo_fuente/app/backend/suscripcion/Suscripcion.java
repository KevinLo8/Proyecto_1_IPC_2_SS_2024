/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.suscripcion;

import com.main.codigo_fuente.app.backend.database.ClaseDBSuscripcion;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author kevin
 */
public class Suscripcion {
    
    private String nombreRevista;
    private String nombreSuscriptor;
    private LocalDate fechaSuscripcion;

    public String getNombreRevista() {
        return nombreRevista;
    }

    public String getNombreSuscriptor() {
        return nombreSuscriptor;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }
    
    public void crearReq(HttpServletRequest req) {
        nombreRevista = req.getParameter("nombreRevista");
        nombreSuscriptor = req.getParameter("nombreSuscriptor");
        fechaSuscripcion = LocalDate.parse(req.getParameter("fechaSuscripcion"));
    }
    
    public void crearRes(ResultSet res) throws SQLException {
        nombreRevista = res.getString("nombre_revista");
        nombreSuscriptor = res.getString("nombre_suscriptor");
        fechaSuscripcion = res.getDate("fecha_suscripcion").toLocalDate();
    }
    
    public void guardarSuscripcion() {
        ClaseDBSuscripcion db = new ClaseDBSuscripcion();
        db.insertSuscripcion(this);
        db.cerrarDB();
    }
    
    public Boolean estaActiva(){
        LocalDate ahora = LocalDate.now();
        
        LocalDate fin = fechaSuscripcion.plusMonths(1);
        
        return ahora.compareTo(fechaSuscripcion) > 0 && ahora.compareTo(fin) > 0;
    }
    
}
