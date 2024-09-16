package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

public class ClaseDBCategorias extends ConectionDB {

    public ClaseDBCategorias() {
        super();
    }

    public ResultSet selectRevistasCategoria(String categoria) {
        String select = "SELECT * FROM categoria_revista WHERE categoria = '" + categoria + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }
    public void insertCategoriaRevista(String nombreRevista, String categoria) {
        String insert = "INSERT INTO categoria_revista (categoria, nombre_revista) "
                + "values('" + categoria + "','" + nombreRevista + "');";

        insertData(insert);
    }

    public ResultSet selectCategorias() {
        String select = "SELECT * FROM categorias;";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertCategoria(String categoria) {
        String insert = "INSERT INTO categorias (categoria) values('" + categoria + "');";

        insertData(insert);
    }
}
