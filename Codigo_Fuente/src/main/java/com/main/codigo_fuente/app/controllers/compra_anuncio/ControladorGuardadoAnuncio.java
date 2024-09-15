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

        if (anuncio.getTipoAnuncio().equals("TEXTO") || anuncio.getTipoAnuncio().equals("TEXTO E IMAGEN")) {
            texto = req.getParameter("texto");
        }
        if (anuncio.getTipoAnuncio().equals("TEXTO E IMAGEN") || anuncio.getTipoAnuncio().equals("VIDEO")) {
            Part filepart = req.getPart("archivo");

            if (filepart != null) {
                InputStream inputStream = filepart.getInputStream();

                Archivo archivo = new Archivo();
                file = archivo.inputStreamToFile(inputStream);
            } else {
                String error = "No se ha seleccionado un archivo para el anuncio.";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/compra_anuncio/ArchivoAnuncio.jsp").forward(req, resp);
            }
        }

        creadorAnuncio.crearAnuncio(anuncio, file, texto);
        req.getRequestDispatcher("/compra_anuncio/CompraAnuncioCompletado.jsp").forward(req, resp);
    }
}
