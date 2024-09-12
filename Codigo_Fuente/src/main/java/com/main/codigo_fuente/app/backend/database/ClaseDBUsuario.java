package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

import com.main.codigo_fuente.app.backend.usuarios.Usuario;

public class ClaseDBUsuario extends ConectionDB {

    public ResultSet selectUser(Usuario usuario) {
        String select = "SELECT * FROM usuario WHERE nombre_usuario = '" + usuario.getNombreUsuario() + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }
    public void insertUser(Usuario usuario) {
        String insert = "INSERT INTO solicitud (nombre_usuario, tipo_usuario, contraseña_usuario) "
        + "values('" + usuario.getNombreUsuario() + "','" + usuario.getTipoUsuario().toString() + "','" 
        + usuario.getContraseñaUsuario() + "');";
        
        insertData(insert);
    }
}
