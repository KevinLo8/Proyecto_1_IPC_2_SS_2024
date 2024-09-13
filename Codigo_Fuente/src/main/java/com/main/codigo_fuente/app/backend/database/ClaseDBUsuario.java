package com.main.codigo_fuente.app.backend.database;

import java.sql.*;

import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import java.time.LocalDate;

public class ClaseDBUsuario extends ConectionDB {

    public ClaseDBUsuario() {
        super();
    }
    
    public ResultSet selectUser(String usuario) {
        String select = "SELECT * FROM usuario WHERE nombre_usuario = '" + usuario + "';";
        ResultSet resultSet = selectData(select);

        return resultSet;
    }

    public ResultSet preparedUser(String usuario, String contraseña) {
        String select = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contraseña = ?;";

        try {
            PreparedStatement statementInsert = connection.prepareStatement(select);
            statementInsert.setString(1, usuario);
            statementInsert.setString(2, contraseña);

            ResultSet resultSet = statementInsert.executeQuery();            
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertUser(Usuario usuario) {
        LocalDate localDate = LocalDate.now();
        String insert = "INSERT INTO usuario (nombre_usuario, rol, contraseña, create_time) "
                + "values('" + usuario.getNombreUsuario() + "','" + usuario.getTipoUsuario().toString() + "','"
                + usuario.getContraseñaUsuario() + "','" + localDate.toString() + "');";

        insertData(insert);
    }
}
