package com.main.codigo_fuente.app.backend.usuarios;

import java.sql.SQLException;

import com.main.codigo_fuente.app.backend.database.ClaseDBUsuario;
import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;

import jakarta.servlet.http.HttpServletRequest;

public class CreadorUsuario {

    private ClaseDBUsuario db = new ClaseDBUsuario();

    public Usuario crearUsuario(HttpServletRequest req) throws UserNameExistsException {

        Usuario Usuario = new Usuario();
        Usuario.crear(req);
        try {
            if (db.selectUser(Usuario).next()) {
                throw new UserNameExistsException("Nombre de usuario ya existente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.insertUser(Usuario);
        db.cerrarDB();

        return null;
    }
}
