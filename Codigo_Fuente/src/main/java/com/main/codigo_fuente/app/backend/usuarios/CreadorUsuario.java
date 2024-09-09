package com.main.codigo_fuente.app.backend.usuarios;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.codigo_fuente.app.backend.database.ConectionDB;
import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;

import jakarta.servlet.http.HttpServletRequest;

public class CreadorUsuario {

    private ConectionDB db = new ConectionDB();

    public Usuario crearUsuario(HttpServletRequest req) throws UserNameExistsException {

        Usuario nuevoUsuario = crearYValidar(req);

        return null;
    }

    private Usuario crearYValidar(HttpServletRequest req) throws UserNameExistsException {

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombreUsuario(req.getParameter("usuario"));
        nuevoUsuario.setTipoUsuario(TipoUsuarioEnum.valueOf(req.getParameter("tipo")));
        nuevoUsuario.setContraseñaUsuario(req.getParameter("contraseña"));

        String select = "SELECT * FROM usuario WHERE nombre = " + nuevoUsuario.getNombreUsuario();
        ResultSet resultSet = db.selectData(select);

        try {
            if (resultSet.next()) {
                throw new UserNameExistsException("Nombre de usuario ya existente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nuevoUsuario;
    }

}
