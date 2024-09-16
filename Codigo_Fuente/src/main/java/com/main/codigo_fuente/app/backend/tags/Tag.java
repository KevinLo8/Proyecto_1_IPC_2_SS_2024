package com.main.codigo_fuente.app.backend.tags;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.main.codigo_fuente.app.backend.database.ClaseDBTags;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class Tag {

    public String[] pedirTags() {
        ClaseDBTags db = new ClaseDBTags();
        ResultSet resultSet = db.selectTags();
        String[] tags = separarTags(resultSet);
        db.cerrarDB();

        return tags;
    }

    private String[] separarTags(ResultSet resultSet) {
        String[] tagsOut = new String[0];

        try {
            while (resultSet.next()) {
                String[] tags = new String[tagsOut.length + 1];

                for (int i = 0; i < tagsOut.length; i++) {
                    tags[i] = tagsOut[i];
                }

                String tag = resultSet.getString("tag");

                if (tagsDiferente(tag, tagsOut)) {
                    tags[tagsOut.length] = tag;
                    tagsOut = tags;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tagsOut;
    }

    private boolean tagsDiferente(String tag, String[] tags) {
        for (int i = 0; i < tags.length; i++) {
            if (tag.equalsIgnoreCase(tags[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean tagExiste(String tag, String[] tags) {
        return !tagsDiferente(tag, tags);
    }

    public void guardarTag(String tag) throws DataErrorException {
        ClaseDBTags db = new ClaseDBTags();

        if (tagExiste(tag, separarTags(db.selectTags()))) {
            db.cerrarDB();
            throw new DataErrorException();
        } else {
            db.insertTag(tag);
            db.cerrarDB();
        }
    }

    public void guardarTags(HttpServletRequest req) {

        String[] tags = req.getParameterValues("tagsSelect");
        String nombreRevista = req.getParameter("nombre");

        ClaseDBTags db = new ClaseDBTags();

        for (String tag : tags) {
            db.insertTagRevista(nombreRevista, tag);
        }
        
        db.cerrarDB();
    }
}
