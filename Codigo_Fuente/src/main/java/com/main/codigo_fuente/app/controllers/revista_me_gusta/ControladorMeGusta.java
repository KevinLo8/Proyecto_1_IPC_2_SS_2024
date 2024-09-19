/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.codigo_fuente.app.controllers.revista_me_gusta;

import com.main.codigo_fuente.app.backend.database.ClaseDBRevista;
import com.main.codigo_fuente.app.backend.revista.Revista;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
@WebServlet(name = "ControladorMeGusta", urlPatterns = {"/revistas-me-gusta/revistas-me-gusta-servlet"})
public class ControladorMeGusta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClaseDBRevista db = new ClaseDBRevista();
        Revista revista = new Revista();
        ResultSet res = db.selectRevista(req.getParameter("nombreRevista"));

        try {
            res.next();
            revista.crearRes(res);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        revista.agregarMeGusta();
        revista.guardarMeGusta();

        resp.sendRedirect(req.getContextPath() + "/revistas-suscritas/revistas-suscritas-servlet");
    }

}
