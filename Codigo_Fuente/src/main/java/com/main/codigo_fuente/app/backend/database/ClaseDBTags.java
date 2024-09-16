package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

public class ClaseDBTags extends ConectionDB {

    public ClaseDBTags() {
        super();
    }

    public ResultSet selectRevistasTag(String tag) {
        String select = "SELECT * FROM tag_revista WHERE tag = '" + tag + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public ResultSet selectTagsRevista(String nombreRevista) {
        String select = "SELECT * FROM tag_revista WHERE nombre_revista = '" + nombreRevista + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertTagRevista(String nombreRevista, String tag) {
        String insert = "INSERT INTO tag_revista (tag, nombre_revista) "
                + "values('" + tag + "','" + nombreRevista + "');";

        insertData(insert);
    }

    public ResultSet selectTags() {
        String select = "SELECT * FROM tags;";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public void insertTag(String tag) {
        String insert = "INSERT INTO tags (tag) values('" + tag + "');";

        insertData(insert);
    }
}
