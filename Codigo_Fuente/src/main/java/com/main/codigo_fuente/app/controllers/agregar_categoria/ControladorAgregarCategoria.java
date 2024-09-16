/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.agregar_categoria;

import com.main.codigo_fuente.app.backend.categoria.Categoria;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorAgregarCategoria", urlPatterns = {"/agregar-categoria/agregar-categoria-servlet"})
public class ControladorAgregarCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] Categotias;

        Categoria categoria = new Categoria();

        Categotias = categoria.pedirCategorias();
        if (categoria.categoriaExiste(req.getParameter("texto"), Categotias)) {
            lanzarError(req, resp, Categotias);
        } else {
            try {
                categoria.guardarCategoria(req.getParameter("texto"));
                resp.sendRedirect(req.getContextPath() + "/publicar-revista/generar-publicacion-servlet");
            } catch (DataErrorException ex) {
                lanzarError(req, resp, Categotias);
            }
        }
    }

    private void lanzarError(HttpServletRequest req, HttpServletResponse resp, String[] tags) throws IOException, ServletException {
        String error = "Categoria escrita ya existente.";
        req.setAttribute("error", error);
        req.setAttribute("tags", tags);
        req.getRequestDispatcher("/publicar-revista/agregar-tag-nuevo.jsp").forward(req, resp);

    }

}
