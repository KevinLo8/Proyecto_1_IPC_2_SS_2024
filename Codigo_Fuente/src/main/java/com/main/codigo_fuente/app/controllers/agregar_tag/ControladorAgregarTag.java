/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.agregar_tag;

import com.main.codigo_fuente.app.backend.tags.Tag;
import com.main.codigo_fuente.app.backend.exceptions.DataErrorException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorAgregarTag", urlPatterns = {"/agregar-tag/agregar-tag-servlet"})
public class ControladorAgregarTag extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tags;

        Tag tag = new Tag();

        tags = tag.pedirTags();
        if (tag.tagExiste(req.getParameter("texto"), tags)) {
            lanzarError(req, resp, tags);
        } else {
            try {
                tag.guardarTag(req.getParameter("texto"));
                resp.sendRedirect(req.getContextPath() + "/publicar-revista/generar-publicacion-servlet");
            } catch (DataErrorException ex) {
                lanzarError(req, resp, tags);
            }
        }
    }

    private void lanzarError(HttpServletRequest req, HttpServletResponse resp, String[] tags) throws IOException, ServletException {
        String error = "Tag escrito ya existente.";
        req.setAttribute("error", error);
        req.setAttribute("tags", tags);
        req.getRequestDispatcher("/publicar-revista/agregar-tag-nuevo.jsp").forward(req, resp);

    }

}
