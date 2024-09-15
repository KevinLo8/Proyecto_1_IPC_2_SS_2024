package com.main.codigo_fuente.app.backend.LogIn;

import com.main.codigo_fuente.app.backend.database.ClaseDBUsuario;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChequeadorLogIn {

    private final ClaseDBUsuario db = new ClaseDBUsuario();

    public Usuario ChequearUsuario(HttpServletRequest req) throws DataErrorException {

        ResultSet dataUsuario = db.preparedUser(req.getParameter("usuario"), req.getParameter("contraseña"));
        Usuario usuario = null;

        try {
            while (dataUsuario.next()) {
                usuario = new Usuario();
                usuario.crearRes(dataUsuario);
            }

            db.cerrarDB();
            
            if (usuario == null) {
                throw new DataErrorException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

}
