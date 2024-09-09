package com.main.codigo_fuente.app.backend.usuarios;

import com.main.codigo_fuente.app.backend.database.ConectionDB;
import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;

import jakarta.servlet.http.HttpServletRequest;

public class CreadorUsuario {

    private ConectionDB db = new ConectionDB();

    public Usuario crearUsuario(HttpServletRequest req) throws UserNameExistsException {

        Usuario nuevoUsuario = crearYValidar(req);
        nuevoUsuario.insertar(db);

        return null;
    }

    private Usuario crearYValidar(HttpServletRequest req) throws UserNameExistsException {

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombreUsuario(req.getParameter("usuario"));
        nuevoUsuario.setTipoUsuario(TipoUsuarioEnum.valueOf(req.getParameter("tipo")));
        nuevoUsuario.setContraseñaUsuario(req.getParameter("contraseña"));

        nuevoUsuario.validar(db);
    
        return nuevoUsuario;
    }

}
