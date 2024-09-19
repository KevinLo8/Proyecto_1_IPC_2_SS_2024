/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.backend.revista;

import com.main.codigo_fuente.app.backend.archivo.Archivo;
import com.main.codigo_fuente.app.backend.categoria.Categoria;
import com.main.codigo_fuente.app.backend.database.*;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import com.main.codigo_fuente.app.backend.suscripcion.Suscripcion;
import com.main.codigo_fuente.app.backend.tags.Tag;
import com.main.codigo_fuente.app.backend.usuarios.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.*;
import java.math.*;
import java.sql.*;

/**
 *
 * @author kevin
 */
public class Revista {

    private String nombreRevista;
    private String usuarioPublicador;
    private String descripcion;
    private InputStream archivoRevista;
    private Double precioRevista;
    private String nombreArchivo;
    private String extencionArchivo;
    private String[] tags;
    private String categoria;
    private Boolean suscrito;
    private int cantidadMeGusta;

    public String getNombreRevista() {
        return nombreRevista;
    }

    public String getUsuarioPublicador() {
        return usuarioPublicador;
    }

    public String getDescripcion() {
        return descripcion;
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

    public String[] getTags() {
        return tags;
    }

    public String getCategoria() {
        return categoria;
    }

    public Boolean getSuscrito() {
        return suscrito;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setPrecioRevista(HttpServletRequest req) {
        precioRevista = Double.valueOf(req.getParameter("precio"));
    }

    public void setSuscrito(Boolean suscrito) {
        this.suscrito = suscrito;
    }

    public void crearReq(HttpServletRequest req) throws DataErrorException, ServletException, IOException {
        nombreRevista = req.getParameter("nombre");

        descripcion = req.getParameter("descripción");

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

        descripcion = res.getString("descripción");

        archivoRevista = res.getBlob("data_revista").getBinaryStream();
        nombreArchivo = res.getString("nombre_archivo");
        extencionArchivo = res.getString("extencion_archivo");

        usuarioPublicador = res.getString("usuario_publicador");

        BigDecimal bd = new BigDecimal(res.getDouble("precio_suscripcion"));
        bd.setScale(2, RoundingMode.CEILING);
        precioRevista = bd.doubleValue();

        cantidadMeGusta = res.getInt("me_gusta");
    }

    public void crearResInfo(ResultSet res) throws SQLException {
        nombreRevista = res.getString("nombre_revista");

        descripcion = res.getString("descripción");

        usuarioPublicador = res.getString("usuario_publicador");

        BigDecimal bd = new BigDecimal(res.getDouble("precio_suscripcion"));
        bd.setScale(2, RoundingMode.CEILING);
        precioRevista = bd.doubleValue();

        cantidadMeGusta = res.getInt("me_gusta");
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

    public void guardarInfo() {
        Tag tag = new Tag();
        String[] tagsData = tag.pedirTagsRevista(nombreRevista);

        Categoria cat = new Categoria();
        String categoriaData = cat.pedirCategoriaRevista(nombreRevista);

        tags = tagsData;
        categoria = categoriaData;
    }

    public Boolean revisarSuscripcion(String nombreUsuario) {
        ClaseDBSuscripcion db = new ClaseDBSuscripcion();

        ResultSet res = db.selectSuscripcion(nombreRevista, nombreUsuario);

        try {
            while (res.next()) {
                Suscripcion suscripcion = new Suscripcion();
                suscripcion.crearRes(res);

                if (suscripcion.estaActiva()) {
                    suscrito = true;
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        suscrito = false;
        return false;
    }

    public void agregarMeGusta() {
        cantidadMeGusta++;
    }

    public void guardarMeGusta() {
        ClaseDBRevista db = new ClaseDBRevista();
        db.updateMeGustaRevista(nombreRevista, cantidadMeGusta);
        db.cerrarDB();
    }

}
