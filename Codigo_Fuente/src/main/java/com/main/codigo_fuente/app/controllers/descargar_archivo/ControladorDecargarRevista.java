/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.descargar_archivo;

import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.revista.Revista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorDecargarRevista", urlPatterns = {"/descargar-revista/descargar-revista-servlet"})
public class ControladorDecargarRevista extends HttpServlet {

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

        try (BufferedInputStream fileStream = new BufferedInputStream(revista.getArchivoRevista())) {
            resp.setContentType(revista.getExtencionArchivo());
            resp.setHeader("Content-disposition", "attachment; filename="+revista.getNombreArchivo());
            int data = fileStream.read();
            while (data > -1) {
                resp.getOutputStream().write(data);
                data = fileStream.read();
            }
        }
    }
}
