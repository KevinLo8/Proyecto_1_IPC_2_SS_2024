/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.agregar_categoria;

import com.main.codigo_fuente.app.backend.categoria.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorCrearAgregarCategoria", urlPatterns = {"/agregar-categoria/agregar-nuevo-categoria-servlet"})
public class ControladorCrearAgregarCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] Categotias;

        Categoria categoria = new Categoria();

        Categotias = categoria.pedirCategorias();

        req.setAttribute("categorias", Categotias);
        req.getRequestDispatcher("/publicar-revista/agregar-categoria-nuevo.jsp").forward(req, resp);

    }

}
