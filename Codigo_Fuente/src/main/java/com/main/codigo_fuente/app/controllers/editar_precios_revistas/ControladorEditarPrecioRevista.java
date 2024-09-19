/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.editar_precios_revistas;

import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.revista.Revista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorEditarPrecioRevista", urlPatterns = {"/precios-revistas/editar-precio-revista-servlet"})
public class ControladorEditarPrecioRevista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        try {
            ResultSet resultSet = db.selectRevista(req.getParameter("nombreRevista"));
            resultSet.next();
            revista.crearRes(resultSet);
        } catch (SQLException ex) {
            db.cerrarDB();
            ex.printStackTrace();
        }
        db.cerrarDB();

        revista.setPrecioRevista(req);
        revista.guardarPrecio();

        req.getRequestDispatcher("/precios-revistas/editar-revista-completado.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        try {
            ResultSet resultSet = db.selectRevista(req.getParameter("nombre"));
            resultSet.next();
            revista.crearRes(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        db.cerrarDB();

        req.setAttribute("revista", revista);
        req.getRequestDispatcher("/precios-revistas/editar-revista.jsp").forward(req, resp);
    }

}
