package com.main.codigo_fuente.app.backend.usuarios;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.*;
import java.time.LocalDate;

public class Usuario {

    private String nombreUsuario;
    private LocalDate fechaCreacion;
    private String contraseñaUsuario;
    private TipoUsuarioEnum tipoUsuario;
    private int credito;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public void crearReq(HttpServletRequest req) {
        nombreUsuario = req.getParameter("usuario");
        tipoUsuario = TipoUsuarioEnum.valueOf(req.getParameter("tipo"));
        contraseñaUsuario = req.getParameter("contraseña");
    }

    public void crearRes(ResultSet resultSet) throws SQLException {
        nombreUsuario = resultSet.getString("nombre_usuario");
        fechaCreacion = resultSet.getDate("fecha_creacion").toLocalDate();
        tipoUsuario = TipoUsuarioEnum.valueOf(resultSet.getString("rol"));
        contraseñaUsuario = resultSet.getString("contraseña");
        credito = resultSet.getInt("credito");
    }

    public boolean saldoSuficiente(int costo) {
        return credito > costo;
    }
}
