package com.main.codigo_fuente.app.backend.usuarios;

import java.sql.*;

import com.main.codigo_fuente.app.backend.database.ConectionDB;
import com.main.codigo_fuente.app.backend.exceptions.UserNameExistsException;

public class Usuario {

    private String nombreUsuario;
    private TipoUsuarioEnum tipoUsuario;
    private String contraseñaUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }
    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }
    public void validar(ConectionDB db) throws UserNameExistsException {

        String select = "SELECT * FROM usuario WHERE nombre_usuario = '" + getNombreUsuario() + "';";
        ResultSet resultSet = db.selectData(select);

        try {
            if (resultSet.next()) {
                throw new UserNameExistsException("Nombre de usuario ya existente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertar(ConectionDB db) {

        String insert = "INSERT INTO solicitud (nombre_usuario, tipo_usuario, contraseña_usuario) "
        + "values('" + nombreUsuario + "','" + tipoUsuario.toString() + "','" 
        + contraseñaUsuario + "');";
        
        db.insertData(insert);

    }

}
