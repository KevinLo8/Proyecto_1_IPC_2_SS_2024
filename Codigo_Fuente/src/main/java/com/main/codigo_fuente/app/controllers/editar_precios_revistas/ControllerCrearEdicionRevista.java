/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.editar_precios_revistas;

import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.revista.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControllerCrearEdicionRevista", urlPatterns = {"/precios-revistas/crear-edicion-revista-servlet"})
public class ControllerCrearEdicionRevista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        ResultSet resultSet = db.selectRevistas();

        Revista[] revistas = Revistas.separarRevistas(resultSet);

        db.cerrarDB();

        req.setAttribute("revistas", revistas);
        req.getRequestDispatcher("/precios-revistas/listado-revistas.jsp").forward(req, resp);
    }

}
