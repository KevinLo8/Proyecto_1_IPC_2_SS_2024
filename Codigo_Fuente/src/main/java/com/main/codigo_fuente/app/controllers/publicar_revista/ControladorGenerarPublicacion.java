/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.publicar_revista;

import com.main.codigo_fuente.app.backend.categoria.Categoria;
import com.main.codigo_fuente.app.backend.tags.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorGenerarPublicacion", urlPatterns = {"/publicar-revista/generar-publicacion-servlet"})
public class ControladorGenerarPublicacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tags;
        String[] categorias;

        Tag tag = new Tag();
        Categoria categoria = new Categoria();

        tags = tag.pedirTags();
        categorias = categoria.pedirCategorias();

        req.setAttribute("tags", tags);
        req.setAttribute("categorias", categorias);
        req.getRequestDispatcher("/publicar-revista/publicar-revista.jsp").forward(req, resp);
    }

}
