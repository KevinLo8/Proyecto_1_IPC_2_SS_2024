/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.reportes;

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
@WebServlet(name = "ControladorReporte5Gustados", urlPatterns = {"/reportes/reporte-5-mas-gustados-servlet"})
public class ControladorReporte5Gustados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Revista[] revistas;

        ClaseDBRevista db = new ClaseDBRevista();
        ResultSet res = db.selectRevistasGustadas();

        revistas = Revistas.separarRevistas(res);
        revistas = Revistas.recortasRevistas(revistas, 5);

        req.setAttribute("revistas", revistas);
        req.getRequestDispatcher("/reportes/mostrar-reporte-revistas.jsp").forward(req, resp);
    }

}
