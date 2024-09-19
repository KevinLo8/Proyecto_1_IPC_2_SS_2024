/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.mostrador_revistas;

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
@WebServlet(name = "ControladorPrevisualizarRevista", urlPatterns = {"/mostrador-revistas/previsualizar-revistas-servlet"})
public class ControladorPrevisualizarRevista extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        ResultSet res = db.selectRevista(req.getParameter("nombreRevista"));

        try {
            res.next();
            revista.crearRes(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        req.setAttribute("revista", revista);
        req.getRequestDispatcher("/mostrador-revistas/previsualizar-revista.jsp").forward(req, resp);
    }

}
