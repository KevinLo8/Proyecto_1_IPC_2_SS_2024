/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.database;

import com.main.codigo_fuente.app.backend.precios_anuncios.PreciosAnuncios;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
public class ClaseDBPreciosAnuncios extends ConectionDB {

    public ClaseDBPreciosAnuncios() {
        super();
    }

    public ResultSet selectPrecios() {
        String select = "SELECT * FROM precios_anuncios";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertPrecios(PreciosAnuncios preciosAnuncios) {
        String insert = "INSERT INTO precios_anuncios (precio_texto, precio_texto_e_imagen, precio_video, precio_1_dia"
                + ", precio_3_dias, precio_1_semana, precio_2_semanas) "
                + "values('" + preciosAnuncios.getPrecioTexto() + "','" + preciosAnuncios.getPrecioTextoEImagen() + "','"
                + preciosAnuncios.getPrecioVideo() + "','" + preciosAnuncios.getPrecio1Dia() + "','"
                + preciosAnuncios.getPrecio3Dias() + "','" + preciosAnuncios.getPrecio1Semana()+ "','"
                + preciosAnuncios.getPrecio2Semanas()+ "');";

        insertData(insert);
    }
}
