/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.agregar_tag;

import com.main.codigo_fuente.app.backend.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorCrearAgregarTag", urlPatterns = {"/agregar-tag/agregar-nuevo-tag-servlet"})
public class ControladorCrearAgregarTag extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tags;

        Tag tag = new Tag();

        tags = tag.pedirTags();

        req.setAttribute("tags", tags);
        req.getRequestDispatcher("/publicar-revista/agregar-tag-nuevo.jsp").forward(req, resp);

    }

}
