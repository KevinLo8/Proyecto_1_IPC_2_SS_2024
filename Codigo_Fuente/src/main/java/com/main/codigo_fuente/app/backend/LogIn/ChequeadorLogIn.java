package com.main.codigo_fuente.app.backend.LogIn;

import com.main.codigo_fuente.app.backend.database.ClaseDBUsuario;
import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;

import jakarta.servlet.http.HttpServletRequest;

public class ChequeadorLogIn {

    private ClaseDBUsuario db = new ClaseDBUsuario();

    public Usuario crearUsuario(HttpServletRequest req) throws UserNameExistsException {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.crear(req);
        db.selectUser(nuevoUsuario);
        db.cerrarDB();

        return null;
    }

}
