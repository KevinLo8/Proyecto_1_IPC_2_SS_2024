/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.compra_anuncio;

import com.main.codigo_fuente.app.backend.anuncio.Anuncio;
import com.main.codigo_fuente.app.backend.anuncio.CreadorAnuncio;
import com.main.codigo_fuente.app.backend.archivo.Archivo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorGuardadoAnuncio", urlPatterns = {"/compra_anuncio/Guardar-Anuncio-servlet"})
public class ControladorGuardadoAnuncio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Anuncio anuncio = (Anuncio) req.getAttribute("anuncio");
        File file = null;
        String texto = null;
        CreadorAnuncio creadorAnuncio = new CreadorAnuncio();

        switch (anuncio.getTipoAnuncio()) {
            case "TEXTO" ->
                texto = req.getParameter("texto");
            case "TEXTO E IMAGEN" -> {
                texto = req.getParameter("texto");
                Archivo archivo = new Archivo();
                file = archivo.inputStreamToFile(extraerInputStream(req, resp), "imagen", ".png");
            }
            case "VIDEO" -> {
                Archivo archivo = new Archivo();
                file = archivo.inputStreamToFile(extraerInputStream(req, resp), "video", ".mp4");
            }
        }

        creadorAnuncio.crearAnuncio(anuncio, file, texto);
        req.getRequestDispatcher("/compra_anuncio/CompraAnuncioCompletado.jsp").forward(req, resp);
    }

    private InputStream extraerInputStream(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filepart = req.getPart("archivo");
        InputStream inputStream = null;

        if (filepart != null) {
            inputStream = filepart.getInputStream();
        } else {
            lanzarError(req, resp);
        }

        return inputStream;
    }

    private void lanzarError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "No se ha seleccionado un archivo para el anuncio.";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/compra_anuncio/ArchivoAnuncio.jsp").forward(req, resp);
    }
}
