/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.publicar_revista;

import com.main.codigo_fuente.app.backend.categoria.Categoria;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import com.main.codigo_fuente.app.backend.revista.Revista;
import com.main.codigo_fuente.app.backend.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorPublicarRevista", urlPatterns = {"/publicar-revista/publicar-revista-servlet"})
public class ControladorPublicarRevista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Revista revista = new Revista();
        try {
            revista.crearReq(req);
        } catch (DataErrorException ex) {
            lanzarError(req, resp);
        }
        revista.guardarRevista();

        Tag tag = new Tag();
        tag.guardarTags(req);
        
        Categoria categoria = new Categoria();
        categoria.guardarCategorias(req);
        
        req.getRequestDispatcher("/publicar-revista/publicacion-revista-completado.jsp").forward(req, resp);
    }


    private void lanzarError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "No se ha seleccionado un archivo para el anuncio.";
        req.setAttribute("error", error);
        req.getRequestDispatcher("/publicar-revista/generar-publicacion-servlet").forward(req, resp);
    }

}
