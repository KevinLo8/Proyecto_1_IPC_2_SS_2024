package com.main.codigo_fuente.app.backend.anuncio;

import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kevin
 */
public class Anuncio {

    private int id;
    private String usuarioComprador;
    private String tipoAnuncio;
    private String duracionAnuncio;
    private LocalDate fechaActivacion;
    private InputStream dataAnuncio;
    private String textoAnuncio;

    public int getId() {
        return id;
    }

    public String getUsuarioComprador() {
        return usuarioComprador;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public String getDuracionAnuncio() {
        return duracionAnuncio;
    }

    public LocalDate getFechaActivacion() {
        return fechaActivacion;
    }

    public InputStream getDataAnuncio() {
        return dataAnuncio;
    }

    public String getTextoAnuncio() {
        return textoAnuncio;
    }

    public void crearReq(HttpServletRequest req, String nombreUsuario) {
        usuarioComprador = nombreUsuario;
        tipoAnuncio = req.getParameter("tipo_anuncio");
        duracionAnuncio = req.getParameter("duracion_anuncio");
        fechaActivacion = LocalDate.parse(req.getParameter("fecha_activacion"));
    }

    public void completarReq(InputStream dataAnuncio, String textoAnuncio) {
        this.dataAnuncio = dataAnuncio;
        this.textoAnuncio = textoAnuncio;
    }
}
