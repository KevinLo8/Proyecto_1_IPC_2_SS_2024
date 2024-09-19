/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.categoria;

import com.main.codigo_fuente.app.backend.database.ClaseDBCategorias;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.*;

/**
 *
 * @author kevin
 */
public class Categoria {

    public String[] pedirCategorias() {
        ClaseDBCategorias db = new ClaseDBCategorias();
        ResultSet resultSet = db.selectCategorias();
        String[] categorias = separarCategorias(resultSet);
        db.cerrarDB();

        return categorias;
    }

    public String pedirCategoriaRevista(String nombreRevista) {
        ClaseDBCategorias db = new ClaseDBCategorias();
        ResultSet resultSet = db.selectCategoriaRevistas(nombreRevista);
        String[] categorias = separarCategorias(resultSet);
        db.cerrarDB();

        return categorias[0];
    }

    private String[] separarCategorias(ResultSet resultSet) {
        String[] categoriasOut = new String[0];

        try {
            while (resultSet.next()) {
                String[] categorias = new String[categoriasOut.length + 1];

                for (int i = 0; i < categoriasOut.length; i++) {
                    categorias[i] = categoriasOut[i];
                }

                String categoria = resultSet.getString("categoria");

                if (categoriaDiferente(categoria, categoriasOut)) {
                    categorias[categoriasOut.length] = categoria;
                    categoriasOut = categorias;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categoriasOut;
    }

    private boolean categoriaDiferente(String categoria, String[] categorias) {
        for (int i = 0; i < categorias.length; i++) {
            if (categoria.equalsIgnoreCase(categorias[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean categoriaExiste(String categoria, String[] categorias) {
        return !categoriaDiferente(categoria, categorias);
    }

    public void guardarCategoria(String categoria) throws DataErrorException {
        ClaseDBCategorias db = new ClaseDBCategorias();

        if (categoriaExiste(categoria, separarCategorias(db.selectCategorias()))) {
            db.cerrarDB();
            throw new DataErrorException();
        } else {
            db.insertCategoria(categoria);
            db.cerrarDB();
        }
    }

    public void guardarCategorias(HttpServletRequest req) {

        String categoria = req.getParameter("categoriaSelect");
        String nombreRevista = req.getParameter("nombre");

        ClaseDBCategorias db = new ClaseDBCategorias();
        db.insertCategoriaRevista(nombreRevista, categoria);
        db.cerrarDB();

    }
}
