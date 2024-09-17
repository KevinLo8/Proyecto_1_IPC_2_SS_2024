/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.revista;

import com.main.codigo_fuente.app.backend.archivo.Archivo;
import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class Revista {

    private String nombreRevista;
    private String usuarioPublicador;
    private InputStream archivoRevista;
    private Double precioRevista;
    private String nombreArchivo;
    private String extencionArchivo;

    public String getNombreRevista() {
        return nombreRevista;
    }

    public String getUsuarioPublicador() {
        return usuarioPublicador;
    }

    public InputStream getArchivoRevista() {
        return archivoRevista;
    }

    public Double getPrecioRevista() {
        return precioRevista;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getExtencionArchivo() {
        return extencionArchivo;
    }

    public void setPrecioRevista(HttpServletRequest req) {
        precioRevista = Double.valueOf(req.getParameter("precio"));
    }

    public void crearReq(HttpServletRequest req) throws DataErrorException, ServletException, IOException {
        nombreRevista = req.getParameter("nombre");

        Archivo archivo = new Archivo();
        archivoRevista = archivo.extraerInputStream(req, "revista");
        nombreArchivo = archivo.extraerNombreArchivo(req, "revista");
        extencionArchivo = archivo.extraerExtencionArchivo(req, "revista");

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        usuarioPublicador = usuario.getNombreUsuario();

        precioRevista = 0.00;
    }

    public void crearRes(ResultSet res) throws SQLException {
        nombreRevista = res.getString("nombre_revista");

        archivoRevista = res.getBlob("data_revista").getBinaryStream();
        nombreArchivo = res.getString("nombre_archivo");
        extencionArchivo = res.getString("extencion_archivo");

        usuarioPublicador = res.getString("usuario_publicador");

        BigDecimal bd = new BigDecimal(res.getDouble("precio_suscripcion"));
        bd.setScale(2, RoundingMode.CEILING);
        precioRevista = bd.doubleValue();
    }

    public void crearResInfo(ResultSet res) throws SQLException {
        nombreRevista = res.getString("nombre_revista");

        usuarioPublicador = res.getString("usuario_publicador");

        BigDecimal bd = new BigDecimal(res.getDouble("precio_suscripcion"));
        bd.setScale(2, RoundingMode.CEILING);
        precioRevista = bd.doubleValue();
    }

    public void guardarRevista() {
        ClaseDBRevista db = new ClaseDBRevista();
        db.insertRevista(this);
        db.cerrarDB();
    }

    public void guardarPrecio() {
        ClaseDBRevista db = new ClaseDBRevista();
        db.updatePrecioRevista(nombreRevista, precioRevista);
        db.cerrarDB();

    }

}
