/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.precios_anuncios;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class PreciosAnuncios {

    private int precioTexto = 0;
    private int precioTextoEImagen = 0;
    private int precioVideo = 0;
    private int precio1Dia = 0;
    private int precio3Dias = 0;
    private int precio1Semana = 0;
    private int precio2Semanas = 0;

    public int getPrecioTexto() {
        return precioTexto;
    }

    public int getPrecioTextoEImagen() {
        return precioTextoEImagen;
    }

    public int getPrecioVideo() {
        return precioVideo;
    }

    public int getPrecio1Dia() {
        return precio1Dia;
    }

    public int getPrecio3Dias() {
        return precio3Dias;
    }

    public int getPrecio1Semana() {
        return precio1Semana;
    }

    public int getPrecio2Semanas() {
        return precio2Semanas;
    }

    public void crear(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                precioTexto = resultSet.getInt("precio_texto");
                precioTextoEImagen = resultSet.getInt("precio_texto_e_imagen");
                precioVideo = resultSet.getInt("precio_video");
                precio1Dia = resultSet.getInt("precio_1_dia");
                precio3Dias = resultSet.getInt("precio_3_dias");
                precio1Semana = resultSet.getInt("precio_1_semana");
                precio2Semanas = resultSet.getInt("precio_2_semanas");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean sonInvalidos() {
        if (precioTexto == 0) {
            return true;
        } else if (precioTextoEImagen == 0) {
            return true;
        } else if (precioVideo == 0) {
            return true;
        } else if (precio1Dia == 0) {
            return true;
        } else if (precio3Dias == 0) {
            return true;
        } else if (precio1Semana == 0) {
            return true;
        } else if (precio2Semanas == 0) {
            return true;
        } else {
            return false;
        }
    }

}
