package com.main.codigo_fuente.app.backend.usuarios;

import com.main.codigo_fuente.app.backend.database.ClaseDBUsuario;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.time.LocalDate;

public class Usuario {

    private String nombreUsuario;
    private LocalDate fechaCreacion;
    private String contraseñaUsuario;
    private TipoUsuarioEnum tipoUsuario;
    private Double credito;
    private String hobbies;
    private String temasInteres;
    private String descripcion;
    private String gustos;

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

    public Double getCredito() {
        return credito;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getTemasInteres() {
        return temasInteres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGustos() {
        return gustos;
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
        credito = resultSet.getDouble("credito");
    }

    public boolean saldoSuficiente(Double costo) {
        return credito > costo;
    }

    public void acreditarSaldo(Double cantidad, ClaseDBUsuario db) {
        credito = credito + cantidad;

        BigDecimal bd = new BigDecimal(credito);
        bd.setScale(2, RoundingMode.CEILING);
        credito = bd.doubleValue();

        db.updateCreditoUsuario(nombreUsuario, credito);
    }

    public void restarSaldo(Double cantidad, ClaseDBUsuario db) {
        credito = credito - cantidad;

        BigDecimal bd = new BigDecimal(credito);
        bd.setScale(2, RoundingMode.CEILING);
        credito = bd.doubleValue();

        db.updateCreditoUsuario(nombreUsuario, credito);
    }

    public void copiarInfo(HttpServletRequest req) {
        hobbies = req.getParameter("hobbies");
        temasInteres = req.getParameter("temasInteres");
        descripcion = req.getParameter("descripción");
        gustos = req.getParameter("gustos");
    }
    
    public void guardarInfo() {
        ClaseDBUsuario db = new ClaseDBUsuario();
        db.updateInfoUsuario(this);
        db.cerrarDB();
    }
}
