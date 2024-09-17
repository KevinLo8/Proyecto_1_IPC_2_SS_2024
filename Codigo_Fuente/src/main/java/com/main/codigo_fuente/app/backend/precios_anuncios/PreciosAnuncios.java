/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.precios_anuncios;

import com.main.codigo_fuente.app.backend.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.*;

/**
 *
 * @author kevin
 */
public class PreciosAnuncios {

    private float precioTexto = 0;
    private float precioTextoEImagen = 0;
    private float precioVideo = 0;
    private float precio1Dia = 0;
    private float precio3Dias = 0;
    private float precio1Semana = 0;
    private float precio2Semanas = 0;

    public Float getPrecioTexto() {
        return precioTexto;
    }

    public Float getPrecioTextoEImagen() {
        return precioTextoEImagen;
    }

    public Float getPrecioVideo() {
        return precioVideo;
    }

    public Float getPrecio1Dia() {
        return precio1Dia;
    }

    public Float getPrecio3Dias() {
        return precio3Dias;
    }

    public Float getPrecio1Semana() {
        return precio1Semana;
    }

    public Float getPrecio2Semanas() {
        return precio2Semanas;
    }

    public void crearReq(HttpServletRequest req) throws DataErrorException, DataEmptyException {
        try {
            precioTexto = Float.parseFloat(req.getParameter("precioTexto"));
            precioTextoEImagen = Float.parseFloat(req.getParameter("precioTextoEImagen"));
            precioVideo = Float.parseFloat(req.getParameter("precioVideo"));
            precio1Dia = Float.parseFloat(req.getParameter("precio1Dia"));
            precio3Dias = Float.parseFloat(req.getParameter("precio3Dias"));
            precio1Semana = Float.parseFloat(req.getParameter("precio1Semana"));
            precio2Semanas = Float.parseFloat(req.getParameter("precio2Semanas"));
        } catch (NumberFormatException ex) {
            throw new DataErrorException();
        } catch (NullPointerException ex) {
            throw new DataEmptyException();
        }
    }

    public void crearRes(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                precioTexto = resultSet.getFloat("precio_texto");
                precioTextoEImagen = resultSet.getFloat("precio_texto_e_imagen");
                precioVideo = resultSet.getFloat("precio_video");
                precio1Dia = resultSet.getFloat("precio_1_dia");
                precio3Dias = resultSet.getFloat("precio_3_dias");
                precio1Semana = resultSet.getFloat("precio_1_semana");
                precio2Semanas = resultSet.getFloat("precio_2_semanas");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean sonInvalidos() {
        if (precioTexto < 1) {
            return true;
        } else if (precioTextoEImagen < 1) {
            return true;
        } else if (precioVideo < 1) {
            return true;
        } else if (precio1Dia < 1) {
            return true;
        } else if (precio3Dias < 1) {
            return true;
        } else if (precio1Semana < 1) {
            return true;
        } else if (precio2Semanas < 1) {
            return true;
        } else {
            return false;
        }
    }

}
